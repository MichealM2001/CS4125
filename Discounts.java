public class Discounts {
    


    public double returnedDiscount(int age, int drivenYears, boolean membership, int membershipYears){

        return isOverAge(age) + numberOfDrivingYears(drivenYears) + membership(membership, membershipYears);

    }

    private double isOverAge(int Age){
        double value = 0;
        
        if (Age >=18 && Age <24){
            value = 2.5;
        }else if(Age >=24){
            value = 4;
        }

        return value;
    }

    private double numberOfDrivingYears(int drivenYears){
        double value = 0;
        
        if(drivenYears>2 && drivenYears < 5){
            value = 2.5;
        }else if(drivenYears >=5){
            value = 4;
        }

        return value;
    }

    private double membership(boolean membership, int years){
        double value =0;

        if(membership){
            if (years >2 && years < 4){
                value = 2.5;
            }else if(years >=4){
                value = 4;
            }
        }

        return value;
    }






// Testing
    // public static void main(String[] args) {
    //     int age = 10;

    //     System.out.println(isOverAge(age));
    // }

}
