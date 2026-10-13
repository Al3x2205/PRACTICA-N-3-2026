class Ballena extends Mamifero{
    public Ballena(){
        super();
    }

    @Override 
    public void metodo1(){
        System.out.println("canta canciones");
    }
    public void nadar(){
        System.out.println("nada profundamente");
    }

    @Override 
    public String toString(){
        return "ballena"
    }
}