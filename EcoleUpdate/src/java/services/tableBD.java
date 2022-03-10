package services;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class tableBD {

    public void insertToTable(Connection connection) throws Exception {
        String classe = this.getClass().getSimpleName();
        Method[] methods = this.getClass().getDeclaredMethods();
        Method[] mInvoke = methodeGetters(methods);

        Statement stmt = null;
        String valeur = "";
        String nomTable = "";
        try {
            for (int i = 0; i < mInvoke.length; i++) {
                if (mInvoke[i].invoke(this) == null && mInvoke[i].getName().compareToIgnoreCase("getId") == 0) {
                    Method setId = this.getClass().getMethod("setId", String.class);//maka an'l methode setID fotsiny ---- getMethod("n anaran'l methode", ny argument misy ao aminy)
                    setId.invoke(this, this.getID(connection));// alefa any @ setID aloha ny id @ alaln'ny sequence (getID(connection))
                }
                Object val = mInvoke[i].invoke(this);
                Object temp = val;

                if ((temp.getClass().getSimpleName()).equals("LocalDate")) {
                    val = getMySqlDate(mInvoke[i]) + ",";
                } else {
                    val = "'" + val + "',";
                }
                nomTable += getAttributs(mInvoke[i]) + ",";
                valeur += val;
            }
            valeur = valeur.substring(0, valeur.length() - 1);
            nomTable = nomTable.substring(0, nomTable.length() - 1);
            String sql = "insert into " + classe + " (" + nomTable + ") values(" + valeur + ")";
            System.out.println(sql);
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            connection.commit();
        } catch (SQLException e) {
        } catch (Exception e) {
        } finally {
            closeTravail(stmt);
        }
    }

    public tableBD[] selectToTable(Connection connection) {
        String operateur = "and";
        String comparaison = "=";
        String classe = this.getClass().getSimpleName();
        Statement stmt = null;
        ResultSet res = null;
        ArrayList<Object> arrayBD = new ArrayList<>();

        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            Method[] mySetMethod = methodeSetters(methods);
            String conditionFinal = getCondition(comparaison, operateur);
            String sql = "select * from " + classe + " " + conditionFinal + "";
            System.out.println(sql);
            stmt = connection.createStatement();
            res = stmt.executeQuery(sql);
            arrayBD = getResultat(res, mySetMethod);
            System.out.println(arrayBD.size() + " ----- length arrayBD");
        } catch (Exception eror) {
        } finally {
            closeTravail(stmt, res);
        }
        tableBD[] retour = Arrays.copyOf(arrayBD.toArray(), arrayBD.toArray().length, tableBD[].class); //mamadika an'le Arraylist ho lasa tableBD[]
        return retour;
    }

    public tableBD[] selectToTable(Connection connection, String sql) {
        String operateur = "and";
        String comparaison = "=";
        String classe = this.getClass().getSimpleName();
        Statement stmt = null;
        ResultSet res = null;
        ArrayList<Object> arrayBD = new ArrayList<>();

        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            Method[] mySetMethod = methodeSetters(methods);

            String conditionFinal = getCondition(comparaison, operateur);
            stmt = connection.createStatement();
            try {
                res = stmt.executeQuery(sql);
                //System.out.println("resultRes : " + res.getObject(9).getClass().getSimpleName());
            } catch (SQLException r) {
                r.printStackTrace();
            }
            System.out.println(sql);
            arrayBD = getResultat(res, mySetMethod);
            System.out.println(arrayBD.size() + " ----- length arrayBD");
        } catch (Exception eror) {

        } finally {
            closeTravail(stmt, res);
        }
        tableBD[] retour = Arrays.copyOf(arrayBD.toArray(), arrayBD.toArray().length, tableBD[].class); //mamadika an'le Arraylist ho lasa tableBD[]
        return retour;
    }

    public void updateToTable(Connection connection) {
        String classe = this.getClass().getSimpleName();
        Method[] methods = this.getClass().getDeclaredMethods();
        Method[] mInvoke = methodeGetters(methods);
        Statement stmt = null;
        String valeur = "";
        String id = "";
        try {
            for (int i = 0; i < mInvoke.length; i++) {
                if (getAttributs(mInvoke[i]).compareToIgnoreCase("id") == 0) {
                    id = mInvoke[i].invoke(this).toString();
                    continue;
                } else {
                    Object val = mInvoke[i].invoke(this);
                    Object temp = val;
                    if ((temp.getClass().getSimpleName()).equals("LocalDate")) {
                        val = getMySqlDate(mInvoke[i]) + ",";
                    } else {
                        val = "'" + val + "',";
                    }
                    valeur += getAttributs(mInvoke[i]) + " = " + val + "";
                }

            }
            valeur = valeur.substring(0, valeur.length() - 1);
            String sql = "update " + classe + " set " + valeur + " where id = '" + id + "'";
            System.out.println(sql);

            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            connection.commit();
        } catch (Exception eror) {
            rollback(connection);
            eror.printStackTrace();
        } finally {
            closeTravail(stmt);
        }

    }

    String getCondition(String comparaison, String operateur) throws Exception {
        Method[] methods = this.getClass().getDeclaredMethods();
        Method[] mInvoke = methodeGetters(methods);                                        // MAKA AN'L METHODES GETTERS 
        ArrayList<Method> methodFinal = new ArrayList<>();
        try {
            for (Method mInvoke1 : mInvoke) {
                if (mInvoke1.invoke(this) != null) {
                    methodFinal.add(mInvoke1);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException eror) {
        }
        Method[] myGetMethod = toMethod(methodFinal); //methodes getters no azo ato, toMethod(ArrayList array) ----> mamadika azy ho lasa type Method[]
        String[] nomColonne = new String[myGetMethod.length];
        Object[] tabCondition = new Object[myGetMethod.length];
        String conditionFinal = "where ";
        try {
            for (int i = 0; i < myGetMethod.length; i++) {
                nomColonne[i] = getAttributs(myGetMethod[i]);
            }
            for (int i = 0; i < myGetMethod.length; i++) {
                Object temp = myGetMethod[i].invoke(this); //invokena l methodes getters azo
                if ((temp.getClass().getSimpleName()).equals("LocalDate")) { // maka ny type'ny valeur azony, et si c'est egale à LocaleDate
                    tabCondition[i] = getMySqlDate(myGetMethod[i]);
                    conditionFinal += "" + nomColonne[i] + " " + comparaison + " " + tabCondition[i] + " " + operateur + " ";
                } else {
                    tabCondition[i] = (myGetMethod[i].invoke(this));
                    conditionFinal += "" + nomColonne[i] + " " + comparaison + " '" + tabCondition[i] + "' " + operateur + " ";
                }
            }
        } catch (Exception eror) {
        }
        if (tabCondition.length == 0) {
            return "";
        }
        conditionFinal = conditionFinal.substring(0, conditionFinal.length() - (operateur.length() + 1));
        return conditionFinal;
    }

    ArrayList<Object> getResultat(ResultSet res, Method[] mySetMethod) throws Exception {

        ArrayList<Object> arrayBD = new ArrayList<>();
        Object myClasse = null;
        //System.out.println("ressssssssssssssss : " + res.getObject());
        while (res.next()) {
            myClasse = this.getClass().getDeclaredConstructor().newInstance();
            for (int i = 0; i < mySetMethod.length; i++) {

                int index = res.findColumn(getAttributs(mySetMethod[i]));//maka an'l nom de colonne ts 1-1 . Manala ny set @ alalan'ny substring

                Object valeurs = res.getObject(index);//alaina ny donnée ao anatiny

                if (valeurs instanceof Number) { //verifie si il y a un number dans la valeur obtenu
                    Number number = (Number) valeurs;
                    mySetMethod[i].invoke(myClasse, number); // Double.parseDouble(String.valueOf(valeurs))
                } else if (valeurs.getClass().getSimpleName().equals("Timestamp")) { //momban'ny date
                    //System.out.println("index date---------> " + index);
                    Timestamp times = Timestamp.valueOf(valeurs.toString());
                    LocalDateTime localDateTime = times.toLocalDateTime();
                    LocalDate localDate = localDateTime.toLocalDate();
                    mySetMethod[i].invoke(myClasse, localDate);
                } else {
                    mySetMethod[i].invoke(myClasse, valeurs);
                }
            }
            arrayBD.add(myClasse);

        }
        return arrayBD;
    }

    Method[] toMethod(ArrayList<Method> method) {
        Method[] retour = new Method[method.size()];
        for (int i = 0; i < method.size(); i++) {
            retour[i] = method.get(i);
        }
        return retour;
    }

    static Method[] methodeGetters(Method[] obj) {
        //Method[] met = obj.getClass().getDeclaredMethods();
        int nb = getNbMethod(obj);
        Method[] list = new Method[nb];
        //System.out.println(list.length + " isanyyyyyy");
        int k = 0;
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].getParameterCount() == 0) {
                list[k] = obj[i];
                //System.out.println(list[k] + " -------- methode get ihany avec k : " + k);
                k++;
            }
        }
        //System.out.println(list[1] + "  -------- methode get avy aty ivelany ihany");
        return list;
    }

    static Method[] methodeSetters(Method[] obj) {
        int nombreMethode = getNbMethod(obj);
        Method[] list = new Method[nombreMethode];;
        int k = 0;
        for (Method met1 : obj) {
            if (met1.getParameterCount() > 0) {
                list[k] = met1;
                k++;
            }
        }
        return list;
    }

    static int getNbMethod(Method[] methods) {
        int cp = 0;
        for (int i = 0; i < methods.length; i++) {
            int nb = methods[i].getParameterCount();
            if (nb > 0) {
                cp++;
                //System.out.println(methods[i].getParameterCount() + " nombre");
            }
        }
        return cp;
    }

    static String getAttributs(Method a) {
        String nomMethod = a.getName();
        String retour = nomMethod.substring(3);
        
        return retour;
    }

    String getMySqlDate(Method mInvoke) throws Exception {
        LocalDate dtn = (LocalDate) mInvoke.invoke(this);
        int year = dtn.getYear();
        int mois = dtn.getMonthValue();
        int day = dtn.getDayOfMonth();
        String sql_temp = " TO_DATE( '" + year + "/" + mois + "/" + day + "','YYYY/MM/dd')";
        sql_temp = sql_temp.substring(1, sql_temp.length());
        System.out.println(sql_temp);

        return sql_temp;
    }

    void closeTravail(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
        }
    }

    void closeTravail(Statement stmt, ResultSet res) {
        try {
            if (stmt != null && res != null) {
                stmt.close();
                res.close();
            }
        } catch (SQLException e) {
        }
    }

    void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getID(Connection connection) {
        String conn = connection.getClass().getSimpleName();
        System.out.println(conn + " : nom connection");
        if ("T4CConnection".equals(conn)) {
            Statement stmt = null;
            ResultSet res = null;
            String mySeq = this.getClass().getSimpleName().toLowerCase();
            String id = mySeq.substring(0, 4).toUpperCase() + "_";
            String sql = "select seq_" + mySeq + ".nextval from dual";
            System.out.println(sql);
            try {
                stmt = connection.createStatement();
                res = stmt.executeQuery(sql);
                int id_pers = 0;
                while (res.next()) {
                    id_pers = res.getInt(1);
                }
                id += Integer.toString(id_pers);

            } catch (SQLException e1) {
            } finally {
                try {
                    stmt.close();
                    res.close();
                } catch (SQLException e) {
                }
            }
            return id;
        } else {
            Statement stmt = null;
            ResultSet res = null;
            String mySeq = this.getClass().getSimpleName().toLowerCase();
            String id = mySeq.substring(0, 4).toUpperCase() + "_";
            String sql = "select nextval('seq_" + mySeq + "')";
            System.out.println(sql);
            try {
                stmt = connection.createStatement();
                res = stmt.executeQuery(sql);
                int id_pers = 0;
                while (res.next()) {
                    id_pers = res.getInt(1);
                }
                id += Integer.toString(id_pers);

            } catch (SQLException e1) {
            } finally {
                try {
                    stmt.close();
                    res.close();
                } catch (SQLException e) {
                }
            }
            return id;
        }
    }
}
