package poly;

import Prog1Tools.IOTools; 

import java.util.Scanner;

/**
 * Software for working with Polynoms
 * @author mehdi dridi
 */
public class Main {
	

	/**
	 * running the software will cause calling the basic menu of choices 
	 * includes tests to make sure that the input is correct
	 */
	public static void main(String[] args) {
		Polynom[] name = new Polynom[100]; 
        Scanner s = new Scanner(System.in);
      
        String n;
		   int choice,d,i=0;
		   do{
			   choice = menu(name,i);
			   String k,k1 ;
			   int w,g;
			 	switch (choice) {
		        case 1:
		        	eingabe(name,i);
		        	i++;
		            break;
		        case 2:
		        	k = IOTools.readString("enter name of polynom !");
		    		 w=wot(name,k);
		    		 if(w==-1){
		    			 msg();
		    		 }else{
		    			 System.out.println(name[w]);
				    		System.out.println("enter to continue !");
				    		s.nextLine(); 
		    		 }
		            break;
		        case 3:
		        	k = IOTools.readString("enter name of polynom !");
		    		 w=wot(name,k);
		    		 
		    		 if(w==-1){
		    			 msg();
		    		 }else{
		    			 name[w].ander();
		    		 }
		            break;
		        case 4:
		        	k = IOTools.readString("enter name of polynom : ");
		    		 w=wot(name,k);
		    		 if(w==-1){
		    			 msg();
		    		 }else{
		    			 g = IOTools.readInteger("enter value : ");
			    		 System.out.print("value is: "+name[w].horner_w(g));
			    		 System.out.println("enter any caracter to continue :");
			    	        n = s.nextLine();
		    		 }
		    		 
		            break;
		        case 5:
		        	k = IOTools.readString("enter name of first polynom !");
		        	k1 = IOTools.readString("enter name of second polynom !");
		    		 w=wot(name,k);
		    		 g=wot(name,k1);
		        	
		        	if(w==-1 || g==-1){
		        		msg();
		    		 }else{
		    			 d=name[w].plus(name[g]).degree();
			    		 if(d>6){
			    			 System.out.println("the result of polynom should be maximal with grad 6 ! ");
			    			 System.out.println("enter any caracter to continue :");
				    	     n = s.nextLine(); 
			    		 }else{
			    			 System.out.println("summe is:"+name[w].plus(name[g]));
				    		 System.out.println("enter any caracter to continue :");
				    	     n = s.nextLine(); 
			    		 }
		    		 }
		        	
		    		 
		    		 break;
		        case 6:
		        	k = IOTools.readString("enter name of first polynom !");
		        	k1 = IOTools.readString("enter name of second polynom !");
		    		 w=wot(name,k);
		    		 g=wot(name,k1);
		    		 
		    		 if(w==-1 || g==-1){
		    			 msg();
		    		 }else{
		    			 System.out.println("minus is:"+name[w].minus(name[g]));
			    		 System.out.println("enter any caracter to continue :");
			    	     n = s.nextLine(); 
		    		 }
		            break;
		        case 7:
		        	k = IOTools.readString("enter name of first polynom !");
		    		 w=wot(name,k);
		        	if(w==-1){
		        		msg();
		    		 }else{
			    		 System.out.println("1.ableitung is : "+name[w].ableitung());
			    		 System.out.println("enter any caracter to continue :");
			    	     n = s.nextLine(); 
		    		 }
		        	
		            break;
		        case 8:
		        	k = IOTools.readString("enter name of first polynom !");
		    		 w=wot(name,k);
		        	if(w==-1){
		    			 msg();
		    		 }else{
		    			 g = IOTools.readInteger("enter X ! :");
			    		 System.out.println(name[w].horner_d(g));
			    		 System.out.println("enter any caracter to continue :");
			    	     n = s.nextLine(); 
		    		 }
		            break;
		        case 9:
		        	k = IOTools.readString("enter name of first polynom !");
		        	k1 = IOTools.readString("enter name of second polynom !");
		    		 w=wot(name,k);
		    		 g=wot(name,k1);
		        	if(w==-1 || g==-1){
		    			 msg();
				    		s.nextLine();
		    		 }else{
		    			 d=name[w].mult(name[g]).degree();
			    		 if(d>6){
			    			 System.out.println("Ergebnis polynom maximal 6 grad haben darf ! ");
			    			 System.out.println("enter any caracter to continue :");
				    	     n = s.nextLine(); 
			    		 }else{
			    			 System.out.println("multiplication ergabnis ist :"+name[w].mult(name[g]));
				    		 System.out.println("enter any caracter to continue :");
				    	     n = s.nextLine(); 
			    		 }
		    		 }
		        	
		    		
		            break;
		        case 10:
		        	exem();
		            break;
		        case 11:
		        	System.out.println("until next time !");
		            break;
		        default:
		            System.out.println("please enter a correct number !");
			    
			 	}

		   }while(choice != 11);	
	    }
	
	/**
	 * the message that should be printed when the input of the user is not correct
	 */
	public static void msg(){
		
		Scanner s = new Scanner(System.in);
		System.out.println("false name or polynom doesn't exist !");
		 System.out.println("enter to continue !");
   		s.nextLine();
	}
	
	/**
	 * this method prepare exemples of the various operations of the software and print them to the user
	 */
	public static void exem(){
		
		Scanner input = new Scanner(System.in);
		Polynom gg = new Polynom(3,"ex1");
		gg.exemple(3);
    	Polynom ggg = new Polynom(3,"ex2");
		ggg.exemple(2);
    	System.out.println("first polynom p1: "+gg);
    	System.out.println();
    	System.out.println("second polynom p2: "+ggg);
    	System.out.println();
    	System.out.println("funktionswert p2 mit 5 : "+ggg.horner_w(5));
    	System.out.println();
    	System.out.println("summe of p1 and p2 : "+ggg.plus(gg));
    	System.out.println();
    	System.out.println("p2 minus p1 : "+ggg.minus(gg));
    	System.out.println();
    	System.out.println("1.ableitung p2 : "+ggg.ableitung());
    	System.out.println();
    	System.out.println("division p2 with 5 : "+ggg.horner_d(5));
    	System.out.println();
    	System.out.println("multiply p2 with p1 : "+ggg.mult(gg));
    	System.out.println();
    	System.out.println();
    	System.out.println("enter any key to continue");
        String selection = input.nextLine();

	}
	
	/**
	 * basic informations of the menu includes printing the stored polynoms
	 */
	public static int menu(Polynom name[],int i) {
        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Input");
        System.out.println("2 - Output");
        System.out.println("3 - change polynom");
        System.out.println("4 - Evaluating polynomials ");
        System.out.println("5 - addition");
        System.out.println("6 - subtraction");
        System.out.println("7 - 1. ableitung");
        System.out.println("8 - horner division");
        System.out.println("9 - multiplication");
        System.out.println("10 - exemple");
        System.out.println("11 - quit");
        System.out.println("-------------------------\n");
        if(i==0){
        	System.out.println("polynom entered: 0");

        }else{
        System.out.println("polynom entered:");
        System.out.println();
    	System.out.format("%2s%31s","name", "Polynom");
    	System.out.println();
        System.out.println("***************************************************\n");

    		for(int j=0;(j<name.length)&&(name[j] != null);j++){
    			System.out.format("%2s%41s\n",name[j].name, name[j]);
    		}
            System.out.println("***************************************************\n");

        }
        
        selection = IOTools.readInteger("enter your choice :");
        
        return selection;    
    }
	
/**
 * stores the polynom of a given name in the ith index of the array of polynoms
 */
public static Polynom[] eingabe(Polynom name[],int i) {
		Scanner s = new Scanner(System.in);
		String k = null;
		int x;
		boolean b =false;
		while(b==false){
			
		 k = IOTools.readString("enter name of polynom :");
		int f = (int) wot(name,k);
		if(f==-1){
			b=true;
		}else{
			System.out.println("name is already taken please try again !");
		}
		}
		
		
		do {
			 x = IOTools.readInteger("enter degree of polynom :");
			 if(x>6){
				 System.out.println("gad maximal 6 please try again !");
			 }
		}while(x>6);
     
      name[i]=new Polynom(x,k);
      name[i].eingabe();
     return name;
    }



/**
 * check if a polynom already exists and if true returns the index of the polynom
 *  if not returns -1
 */
public static int wot(Polynom name[],String k){
	int p =-1;
	for(int i=0;(i<name.length)&&(name[i] != null);i++){
		if(name[i].name.equals(k))
			p=i;
	}
	return p;
}



}
