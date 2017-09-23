/*
 * ALEJANDRA RIVERA LÓPEZ 140385
 *
 * AUTOMATA FINITO DETERMINÍSTICO
 * EXPRESIÓN REGULAR = 1(00^*)^*

   De acuerdo a la expresión regular que se tiene, únicamente serán válidas las cadenas que empiezan con 1 concatenado con 0^*
   Para poder cumplir con la expresión regular, inicialize la variable aceptado = true, haciendo que todas las cadenas sean 
   válidas, pero, si entran a un estado no válido, la variable aceptado será = false;
   El programa esta válidado para que no acepte cadenas que cotengan caracteres diferentes a '0' o '1', así se evita que 
   cadenas inválidas como "a12s", las muestre como válidas.
   Como se muestra en el programa, se tienen los estados q0, q1 y el estado de error. 
    -Si el primer caracter es el 0, se manda llamar al estado de error.
    -Si el primer caracter es el 1, se manda llamar al estado q1.
    -Si en el estado q1 se tiene que caracter es igual a 0, se manda llamar a q1.
    -Si en el estado q1 se tiene que caracter es igual a 1, se manda llamar al estado de error.

 */
package automata;

import java.util.*;//importacion de librerias

/**
 *
 * @author Alejandra Rivera López
 * 140385
 */
public class Automata {
    //declaracion de variables
    int cont;
    static int op=0;
    static char[] car;
    boolean aceptado=true;//se inicializó la variable aceptado = true
    
    public static void main(String[] args) {
        Scanner entra = new Scanner(System.in);//declaracion de la variable entra para poder ingresar la cadena
        Automata aut = new Automata();//instancia
        System.out.println("La expresión regular del automata finito determinístico es: 1(00^*)^*");
        do//ciclo para que el usuario ingrese una cadena que  contenga especificamente los caracteres '0' y '1'
        {
            System.out.println("\nIngresa la cadena");
            String cadena = entra.nextLine();// se guarda la cadena que ingresa el usuario en la variable cadena
            car = cadena.toCharArray();//se guarda la cadena en un arreglo tipo char llamado car
            for(int i =0; i<car.length; i++)//recorre cada caracter de la cadena
            {
                if (car[i]=='0' || car[i]=='1')//si la cadena es igual a '0' o '1'
                {    
                    op=1;//opcion es igual a 1 para que termine el ciclo do while
                    break;//sale del ciclo for
                }
            }
            if(op==0)
                {
                    System.out.println("\nError! solo puede ingresar ceros o unos");
                }
        }while(op==0);//mientras la opcion sea cero, se estará ciclando el do while
        aut.inicio();//llamada al método inicio
    }
    
    public void inicio()//método inicio
    {
        cont=0;
        q0();//llamada al método q0
        if(aceptado==true)//si la cadena se encuentra dentro de la expresión regular se imprime que es válidaa
        {
            System.out.println("\nLa cadena introducida es válida");
        }
        else if(aceptado==false)//Si no se encuentra, se imprime que es inválida
        {
            System.out.println("\nLa cadena introducida es inválida");
        }
    }
    
    public void q0()//método q0
    {
        if (cont<car.length)//valida si el contador es menor que el tamaño del arreglo char
        {
            if (car[cont]=='0')//valida si el caracter en la poscion del contador es igual a 0
            {
                cont ++;//al contador se le suma 1
                qerror();//se manda llamar al método qerror
            }
            else if(car[cont]=='1')//valida si el caracter en la posicion del contador es igual a 1
            {
               cont ++;//al contador se le suma 1
               q1();//manda llamar al método q1
            }
        }
    }
    
    public void q1()//método q1
    {
        if (cont<car.length)//valida si el contador es menor al tamaño del arreglo char
        {
            if (car[cont]=='0')//checa si el caracter en a posicion del contador es igual a 0
            {
                cont ++;//se le suma 1 a contador
                q1();//se llama al método q1
            }
            else if(car[cont]=='1')//checa si el caracter en a posicion del contador es igual a 0
            {
               cont ++;//se le suma 1 al contador
               qerror();//se llama al método qerror
            }
        }
    }
    
    public void qerror()//método qerror
    {
        //si la cadena entra a este método, es porque no es válida por lo que la variable "aceptacion",
        //cambia a false, así es como se indica que la cadena no es válida
        aceptado=false;
    }
   
}
