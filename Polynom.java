package poly;
import Prog1Tools.IOTools; 

public class Polynom {
	private int[] coef;
	private int deg;
	public String name;
	
	public Polynom(int d, String n){
		this.deg=d;
		this.name=n;
        coef = new int[d+1];
	}
	
	
	 /**
	 * this method calculates the value of a polynom with the Horner's method
	 */
	public int horner_w(int x) {
	        int p = 0;
	        for (int i = deg; i >= 0; i--)
	            p = coef[i] + (x * p);
	        return p;
	    }
	/**
	 * this method divide two polynoms by the Horner's method 
	 */
	 public Polynom horner_d(int x) {
		Polynom a = this;
		Polynom b = new Polynom(a.deg-1,"");
		b.coef[a.deg-1]=a.coef[a.deg];
		int f = 0,r=a.deg-2;
		for(int i=a.deg-2;i>=0;i--){
			b.coef[i]=(b.coef[i+1]*x)+a.coef[i+1];
			f=b.coef[i];
		}
		f=(f*x)+a.coef[0];
		return b;
	 }
	
	/**
	 * this is the functions wish is responsible for filling the coefficients of the polynom
	 */
	public void eingabe(){
		
		for(int i=0;i<=deg;i++){
			coef[i]= IOTools.readInteger("fill coefficient of x^"+i);
		}
	}
	
	 /**
	 * this method calculates the degree of the polynom by checking the null coefficients
	 */
	public int degree() {
		 
	        int d = 0;
	        for (int i=0; i<coef.length;i++)
	            if (coef[i]!=0){
	            	d = i;
	            }
	        return d;
	    }
	
	/**
	 * this method loops through coefficients to change it's values
	 */
	public void ander(){
		
		Polynom a = this;
		for(int i=0;i<=a.deg;i++){
			a.coef[i]= IOTools.readInteger("fill coefficient of x^"+i);
			
		}
	}
	
	/**
	 * this method generates an exemple to show to the user
	 */
	public void exemple(int c){
		
		for(int i=0;i<=deg;i++){
			coef[i]=i+c;
		}
	}
	
	
    /**
     * this method add two polynoms and return the summ
     */
    public Polynom plus(Polynom b) {
    	
    	Polynom a = this;
    	Polynom c = new Polynom(Math.max(a.deg, b.deg),"");
        for (int i = 0; i <= a.deg; i++){ 
        	c.coef[i] += a.coef[i];
        }
        for (int i = 0; i <= b.deg; i++){
        	c.coef[i] += b.coef[i];
        }
        c.deg = Math.max(a.deg, b.deg);
        return c;
    }
    
    /**
     * this method subtract a polynom from another and return the result polynom
     */
    public Polynom minus(Polynom b) {
    	
    	Polynom a = this;
    	Polynom c = new Polynom(Math.max(a.deg, b.deg),"");
        for (int i = 0; i <= a.deg; i++){
        	c.coef[i] += a.coef[i];
        }
        for (int i = 0; i <= b.deg; i++){
        	c.coef[i] -= b.coef[i];
        }
        c.deg = Math.max(a.deg, b.deg);
        return c;
    }
    
    /**
     * this method multiply two polynoms and return the result polynom
     */
    public Polynom mult(Polynom b){
    	Polynom a = this;
    	Polynom c = new Polynom(a.deg+b.deg,"");
    	for(int i = 0; i <= a.deg; i++)
            for(int j = 0; j <= b.deg; j++)
                c.coef[i+j] += a.coef[i]*b.coef[j];
        return c;

    }
    
    
    /**
     * this method return the ableitung polynom 
     */
    public Polynom ableitung() {
    	
        if (deg == 0) return new Polynom(0,"");
        Polynom diff = new Polynom(deg-1,"");
        diff.deg = deg - 1;
        for (int i = 0; i < deg; i++){
        	diff.coef[i] = (i + 1) * coef[i + 1];
        }
        return diff;
    }
    
    
    /**
     * this method returns the value of a polynom with a given integer and returns the value without the the Horner's method
     */
    public int wert(int x){
    	
    	Polynom p = this;
    	int w = 0;
    	for(int i=0;i<=p.deg;i++){
    		w= (int) (w+(p.coef[i]*Math.pow(x, i)));
    	}
    	return w;
    }
	
    /*
     * this method convert a polynom to string representation 
     */
    public String toString() {
    	
        if (deg ==  0){ 
        	return "" + coef[0];
        }
        if (deg ==  1) {
      
        	return coef[1] + "x + " + coef[0];
        	
        }
        String s = coef[deg] + "x^" + deg;
        for (int i = deg-1; i >= 0; i--) {
            if      (coef[i] == 0) continue;
            else if (coef[i]  > 0) s = s + " + " + ( coef[i]);
            else if (coef[i]  < 0) s = s + " - " + (-coef[i]);
            if      (i == 1) s = s + "x";
            else if (i >  1) s = s + "x^" + i;
        }
        return s;
    }
}
