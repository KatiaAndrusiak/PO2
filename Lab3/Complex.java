import com.sun.org.apache.xpath.internal.operations.Bool;

public class Complex {
    private double re = 0.0;
    private double im = 0.0;

    static final Complex I =  new Complex(0,1.0);
    static final Complex ONE = new Complex(1.0);
    static final Complex ZERO = new Complex(0.0);

    Complex(){
        re = 0.0;
        im = 0.0;
    }

    Complex(double Re) {
        re = Re;
        im = 0.0;
    }
    Complex(double Re, double Im) {
        re = Re;
        im = Im;

    }

    public String toString(){
        if( im < 0)
            return re +" - "+ Math.abs(im)+"i";
        else if( re==0.0 && im ==0.0)
            return "0.0";
        else if(re == 0.0)
            return im + "i";
        else if(im == 0.0)
            return re +"";
        else
            return  re +" + "+im+"i";
    }

    public double getRe(){
        return re;
    }
    public double getIm(){
        return im;
    }

    public static Complex add(Complex c1, Complex c2){
        return new Complex(c1.re+c2.re, c1.im+c2.im);
    }
    public static Complex subtract(Complex c1, Complex c2){
        return new Complex(c1.re-c2.re, c1.im-c2.im);
    }
    public static Complex multiply(Complex c1, Complex c2){
        return  new Complex( c1.re * c2.re - c1.im * c2.im , c1.im * c2.re + c1.re * c2.im);
    }

    public static Complex multiply(Complex c1, Double d2){
        return  new Complex(c1.re * d2, c1.im * d2);
    }

    public static Complex divide(Complex c1, Complex c2){
        return  new Complex( (c1.re * c2.re + c1.im * c2.im)/(c2.re*c2.re +c2.im*c2.im) , (c1.im * c2.re - c1.re * c2.im)/(c2.re*c2.re +c2.im*c2.im));
    }

    public double mod(){
        return  Math.sqrt(re*re + im*im);
    }

    public static Complex sqrt( double d){
        if(d>0)  return  new Complex(Math.sqrt(d));
        else return  new Complex(0,Math.sqrt(Math.abs(d)));
    }

    public Boolean equals(Complex c){
        return   this.re == c.re && this.im == c.im;
    }
    public void conjugate(){
        this.im = - this.getIm();
    }
    public void opposite(){
        this.re = - this.getRe();
        this.im = - this.getIm();
    }
}
