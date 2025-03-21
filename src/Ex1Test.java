import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/*
all the tests for the assigntment are here
 */

class Ex1Test {
    BP_Server game = new BP_Server();   // Starting the "game-server"
    long myID = 315489534;


    int numOfDigits =6;

// this function calculate the avarage of 100 games solutions. (the numof digits is general so we change the general num of digit and not need to change it inside the test).
@Test
    void autoEx1GameTest(){
        double avarage=0;

        for (int i=0;i<100;i++){
            System.out.println(i);
            game.startGame(myID, numOfDigits);
            Ex1.autoEx1Game(game);
        }
        avarage = (double) Ex1.ind / 100;
        System.out.println("the avarage is: "+avarage);

        assertTrue(avarage<8);

    }

    // this function toed a general avarge - take the avarage of all the optional num of digitgs
    @Test
    void TotalAvarageTest(){
        {
            double avarage=0;
            for(int i=2;i<=6;i++){
                for (int j=0;j<100;j++){
                    game.startGame(myID, i);
                    Ex1.autoEx1Game(game);
                  //  autoEx1GameTest();
                }
            }
            avarage=(double) Ex1.ind/500;
            assertTrue(avarage<8);
            System.out.println("the final avavarage is: "+avarage);


        }

    }
}