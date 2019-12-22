public class Lab4
{
    public static void turnRight()
    {
        Robot.turnLeft();
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void turnAround()
    {
        Robot.turnLeft();
        Robot.turnLeft();
    }

    public static void backUp()
    {
        turnAround();
        Robot.move();
        turnAround();
    }

    public static void completeBars()
    {
        //insert instructions below
        while (Robot.frontIsClear()){
            completeBar();
            Robot.move(); 
        }
        completeBar(); 
    }

    public static void completeBar()
    {
        Robot.turnLeft(); 
        while (!Robot.onDark()){
            Robot.move();
        }
        turnAround();
        while (Robot.frontIsClear()){
            Robot.move();
            Robot.makeDark(); 
        }
        Robot.turnLeft();
        //Pre: Bar above Robot is not complete
        //Post: Bar above Robot is complete. Robot is in the same position. 
    }

    public static void testCompleteBars1()
    {
        Robot.load("bars1.txt");
        Robot.setDelay(0.025);
        completeBars();
    }

    public static void testCompleteBars2()
    {
        Robot.load("bars2.txt");
        Robot.setDelay(0.025);
        completeBars();
    }

    public static void combinePiles()
    {
        //insert instructions below
        while (Robot.onDark()){
            addPile2SubtractPile1();
        }
    }

    public static void addPile2SubtractPile1(){
        subtractPile1();
        Robot.turnLeft(); 
        Robot.move(); 
        Robot.turnLeft();
        addPile2(); 
        turnRight();
        Robot.move();
        turnRight(); 
        //Pre: Piles are an unknown number of dark squares tall
        //Post: Left pile is one dark square shorter and right is one taller
    }

    public static void subtractPile1(){
        while(Robot.onDark() && Robot.frontIsClear()){
            Robot.move();
        }
        if(Robot.onDark()){
            Robot.makeLight(); 
        }
        else{
            backUp();
            if(Robot.onDark()){

                Robot.makeLight();
            }
        }
        turnAround();
        while(Robot.frontIsClear()){
            Robot.move();
        }
        //Pre: Left pile is an unknown number of dark squares tall
        //Post: Left pile is one dark square shorter
    }

    public static void addPile2(){
        while(Robot.onDark() && Robot.frontIsClear()){
            Robot.move();
        }
        if(!Robot.onDark()){
            Robot.makeDark();
        }
        turnAround(); 
        while(Robot.frontIsClear()){
            Robot.move(); 
        }
        //Pre: Right pile is an unknown number of dark squares tall
        //Post: Right pile is one dark square taller
    }

    public static void testCombinePiles1()
    {
        Robot.load("piles1.txt");
        Robot.setDelay(0.025);
        combinePiles();
    }

    public static void testCombinePiles2()
    {
        Robot.load("piles2.txt");
        Robot.setDelay(0.025);
        combinePiles();
    }

    public static void connectDots()
    {
        //insert instructions below
        while(Robot.onDark()){
            nextDot(); 
        }
    }

    public static void checkForward(){
        if(Robot.frontIsClear()){
            Robot.move();
        }
        if(Robot.frontIsClear()){
            Robot.move();
        }
        //Pre: Robot is on a square
        //Pre: Robot moves two units forward if possible and one if two isn't and one is possible. 
    }

    public static void returnToDot(){
        while (!Robot.onDark()){
            backUp();  
        }
        //Pre: Robot an unknown distance away from the current dot and facing forwards
        //Post: Robot faces the same direction but is on the current dot 
    }

    public static void connectDot(){
        backUp();
        Robot.makeDark();
        Robot.move();
        //Pre: Robot is on the next dot
        //Post: Current dot and next dot are connected. Robot is on what used to be the next dot 
    }

    public static void nextDot(){
        checkForward(); 
        if (Robot.onDark()){
            connectDot();
        }
        else{
            returnToDot();
            Robot.turnLeft();
            checkForward();
            if(Robot.onDark()){
                connectDot(); 
            }
            else{
                returnToDot();
                turnAround(); 
                checkForward(); 
                if(Robot.onDark()){
                    connectDot(); 
                }
            }
        }
        //Robot is on the current dot
        //Robot has found the next dot and connected it to the current dot. Robot is on what used to be the next dot
    }

    public static void testConnectDots1()
    {
        Robot.load("connect1.txt");
        Robot.setDelay(0.025);
        connectDots();
    }

    public static void testConnectDots2()
    {
        Robot.load("connect2.txt");
        Robot.setDelay(0.025);
        connectDots();
    }
}
