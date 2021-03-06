package de.tub.ilke;

/**
 * Created by izi on 8/9/16.
 */

import org.chocosolver.solver.constraints.real.Ibex;


public class IbexTest {

    public static void main(String[] args) {

        Ibex ibex=new Ibex();
        //ibex.add_contractor(2,"{0}-{1}=0");
        //ibex.add_ctr(2,"{0}-{1}=0");


        double domains[]={1.5,10.5,5.5,12.0};
        System.out.println("Before contract:");
        System.out.println("(["+domains[0]+","+domains[1]+"] ; ["+domains[2]+","+domains[3]+"])");

        int result=ibex.contract(0,domains);

        if (result==Ibex.FAIL) {
            System.out.println("Failed!");
        } else if (result==Ibex.CONTRACT) {
            System.out.println("After contract #0:");
            System.out.println("(["+domains[0]+","+domains[1]+"] ; ["+domains[2]+","+domains[3]+"])");
        } else {
            System.out.println("Nothing.");
        }


        //ibex.add_int_ctr(2);
        ibex.contract(1,domains);
        System.out.println("After contract #1:");
        System.out.println("(["+domains[0]+","+domains[1]+"] ; ["+domains[2]+","+domains[3]+"])");

        //ibex.release();
    }





}