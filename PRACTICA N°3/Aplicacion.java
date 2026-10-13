public class Aplicacion {
public static void main ( String [] args ) {
CriaturaMarina [] elementos = { new Calamar () , new Delfin () , new
Mamifero () , new CriaturaMarina (), new Ballena() };
for (int i = 0; i < elementos . length ; i ++) {
2
System . out . println ( elementos [ i ]) ;
elementos [ i ]. metodo1 () ;
elementos [ i ]. metodo2 () ;
System . out . println () ;
}
}
}