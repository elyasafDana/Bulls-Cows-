import java.util.Scanner;
/**
 * Introduction to Computer Science, Ariel University, Ex1 (manual Example + a Template for your solution)
 * See: https://docs.google.com/document/d/1C1BZmi_Qv6oRrL4T5oN9N2bBMFOHPzSI/edit?usp=sharing&ouid=113711744349547563645&rtpof=true&sd=true
 *
 * Ex1 Bulls & Cows - Automatic solution.
 * in order to active the game we need to insert an id and number of digit into the function game.startGame().
 * the game is simple we need to guess(in the manual program) a digits  in the same order
 * in every guess that we make we get bulls and cows that help me to get closer to the hidden number if i guessed the hidden
 * number the bos are the number of the digits.
 * in this program we writed a code that solve the game when he has a number between 2-6.
 *
 * **** General Solution (algorithm) ****
 * Add your explanation here:
 * 1.we create a new arry that contain all the optional numbers for example:2 digit 100 options
 * 2.we raffle a number and get the solution : how many bulls and cows we got.
 * 3.each number in the arry that gives me NOT the same solution we delete (because this number canot be optional solution).
 * 4.we raffle a new number and go back to 3. we stop when we got win.
 *

 * **** Results ****
 * Make sure to state the average required guesses
 * for 2,3,4,5,6 digit code:
 *
 * Average required guesses 2: 6.23
 * Average required guesses 3: 6.74
 * Average required guesses 4: 7.2
 * Average required guesses 5: 7.62
 * Average required guesses 6: 7.71
 * general avarage: 6.964
 */

public class Ex1 {
    static int ind=1; // index of the guess
    static int count=0;// this int count the times that we played the game- good for the test.
    public static final String Title = "Ex1 demo: manual Bulls & Cows game";
    public static void main(String[] args) {
        System.out.println("please enter the number of digits:");
        Scanner in =new Scanner(System.in);
        BP_Server game = new BP_Server();   // Starting the "game-server"
        long myID = 315489534L;             // Your ID should be written here
        int numOfDigits = in.nextInt();                // Number of digits [2,6]
        game.startGame(myID, numOfDigits);  // Starting a game
        System.out.println(Title+" with code of "+numOfDigits+" digits");
        for (int i=0;i<100;i++){
            System.out.println(i);
            autoEx1Game(game);
        }
        //autoEx1Game(game); // you should implement this function )and any additional required functions).
        //manualEx1Game(game);
    }

    /**
     * This function solves the Bulls & Cows game automatically.
     * the algorithem of the function is declared in the begining of the program-(in General Solution (algorithm) )
     *@ bp game server - the server of the game.
     *
     *
     */
    public static void autoEx1Game(BP_Server game) {
        Scanner in =new Scanner(System.in);
        int numOfDigits = game.getNumOfDigits();
        double max = Math.pow(10,numOfDigits);
        int size=(int) max;
        int[] arr=new int[size]; // arr of all the potentials options
        for(int i=0;i<arr.length;i++){ // restart the arry of the potentionals nums.
            arr[i]=i;
        }
        int g; // pick a guess.
        int[] guess; // each place in the arry contain the digit of guess
        int[] res;
        if (ind>1)ind++; // for the test.
        while(game.isRunning()) {           // While the game is running (the code has not been found yet
            g = (int) (Math.random()*Math.pow(10,numOfDigits)); // pick a random number in the range of the number of digits.
            if (arr[g]==-1) // -1 means that the number can not be the win of the game . if g is so pick the first optional number.
            for (int i=0;i<arr.length;i++){
                if(arr[i]!=-1){
                    g=arr[i];
                    i= arr.length; // get out of the loop
                }
            }
            System.out.println(ind+") " + g);
            guess=toArray(g, numOfDigits);
            res = game.play(guess);
            if(g>=0 && g<max) { // if g is in the range
                if (res[0]!= numOfDigits) arr[g]=-1;// if the guess in not the win answer set him to-1(not optional guess for win).
                if (game.isRunning()) {     // While the game is running
                    System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
                    for(int i=0;i<arr.length;i++) // run all over the arr of otional win guess and compare result(how many bulls and how many cows) of the optionals win number with the result of the guess .
                        if ( (arr[i]!=-1) ){ // if the  arry of options in place i is -1 go to another i
                            if(! (compare(arr[i],guess,res))){ // if the compare of guess and arr[i] is not the res the arr[i] cant be a soulotion so set him to-1.
                                arr[i]=-1;
                            }
                        }

                    if(game.isRunning())ind += 1;               // Increasing the index
                }
            }
            else {
                System.out.println("ERR: wrong input, try again");
            }
        }
        count++;
        System.out.println(game.getStatus());
    }

    public static void manualEx1Game(BP_Server game) {
        Scanner sc = new Scanner(System.in);
        int numOfDigits = game.getNumOfDigits();
        double max = Math.pow(10,numOfDigits);
        while(game.isRunning()) {           // While the game is running (the code has not been found yet
            System.out.println(ind+") enter a guess: ");
            int g = sc.nextInt();
            if(g>=0 && g<max) {
                int[] guess = toArray(g, numOfDigits); // int to digit array
                int[] res = game.play(guess); // Playing a round and getting the B,C
                if (game.isRunning()) {     // While the game is running
                    System.out.println(ind + ") B: " + res[0] + ",  C: " + res[1]); // Prints the Bulls [0], and the Cows [1]
                    ind += 1;               // Increasing the index
                }
            }
            else {
                System.out.println("ERR: wrong input, try again");
            }
        }
        System.out.println(game.getStatus());
    }

    /**
     * this function prints all the arry of the optional win number, the print is like a table.
     * @param arr - an arry that contain all the optional win number
     * @param numOfdig a natural number as the number of digits that we are playing the game with.
     * @return nothing only prints
     */
    public static void printarr(int[] arr,int numOfdig){
    int num= (int) (Math.pow(10,numOfdig-1));
        for (int i=0;i<arr.length;i++){
            if (i%num==0) System.out.println();
            System.out.print(" "+arr[i]);

        }
        System.out.println();
    }

    /**
     * this function compare the result(b and c) of an optional number for win with the result(b and c ) of the guess that we already picked .and return if the result is equal.
     * @param num - a natural number as the number of the optional win number.
     * @param guess - an arry that contain the guess that we already picked .
     * @param res- an arry that contain the bulls and cows of the guess with the hidden number(the win number).
     * @return true  if the res equal to num result. and false otherwise.
     */
    public static boolean compare(int num, int[] guess, int[] res){
        int b=0,c=0; // variables that count the bulls and cows of the optional number with the guess number.
        int[] numdig= toArray(num,guess.length); // arry that contain the digits of the optional win number
        int[] tempguess=new int[guess.length]; // we dont want to cange the guess so we copy the digits of guess to new arry
        for (int i=0;i< guess.length;i++)tempguess[i]=guess[i];// create new guess arry

        for(int i=0;i<guess.length;i++){// find the bolls: if the we have 2 equal digits in the same place in the optional win number  and guess bolls++.
            if(tempguess[i]==numdig[i]) {
                b++;
                tempguess[i] = -1;// -1 is a flag that mean that this digit is already bolls so we wont need to cheack him in the futere
                numdig[i] = -1;//
            }
        }

        for (int i=0;i<guess.length;i++){ // find  how many cow are betwen the guess and the optional number

            if (tempguess[i]!=-1) // if the number is not already used for bulls or cows contiue
                for(int j=0;j<guess.length;j++){
                    if(numdig[j]!=-1) {
                        if (tempguess[i] == numdig[j]) { // if c is found
                            c++;
                            tempguess[i] = -1;
                            numdig[j] = -1;
                            j=guess.length;// we found what we looked for go to another i
                        }
                    }
                }
        }
          if(res[0]==b && res[1]==c){
              return true;
          }
        else return false;
    }


    /**
     * Simple parsing function that gets an int and returns an array of digits
     * @param a - a natural number (as a guess)
     * @param size  - number of digits (to handle the 00 case).
     * @return an array of digits
     */
    private static int[] toArray(int a, int size){
        int[] c = new int[size];
        for(int j=0;j<c.length;j+=1) {
            c[j] = a%10;
            a=a/10;
        }
        return c;
    }
////////////////////////////////////////////////////




}
