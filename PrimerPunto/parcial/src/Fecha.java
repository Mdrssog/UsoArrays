public class Fecha {
    private int dia;
    private int mes;
    private int año;

    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    //Métodos get y set
    public int getDia() {
        return this.dia;
    }

    public void setDia(int d) {
        this.dia = d;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int m) {
        this.mes = m;
    }

    public int getAño() {
        return this.año;
    }

    public void setAño(int a) {
        this.año = a;
    }

    //Comprobar si la fecha es correcta
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, añoCorrecto;
        añoCorrecto = año > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && añoCorrecto;
    }

    //Comprobar si el año es bisiesto
    //Método privado invocado desde el método fechaCorrecta
    private boolean esBisiesto() {
        return (año % 4 == 0 && año % 100 != 0 || año % 400 == 0);
    }

    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                año++;
            }
        }
    }

    //Método para comprobar si la fecha es mayor que la que se recibe
    public boolean esMayorQue(Fecha f) {
        if (año > f.año) {
            return true;
        } else if (año == f.año && mes > f.mes) {
            return true;
        } else if (año == f.año && mes == f.mes && dia > f.dia) {
            return true;
        }
        return false;
    }

    //Método para mostrar la fecha
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.dia < 10) {
            sb.append("0");
        }
        sb.append(this.dia);
        sb.append("-");
        if (this.mes < 10) {
            sb.append("0");
        }
        sb.append(this.mes);
        sb.append("-");

        sb.append(this.año);
        return sb.toString();
    }
}

