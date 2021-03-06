package bots;
import pirates.*;


import java.util.*;

class History {
    
    static ArrayList<List<Pirate>> myPirates;
    public History(){
        myPirates = new ArrayList<>();
    }
    private PirateGame game;
    void update(List<Pirate> mylivingPirates, PirateGame game) {
        this.game = game;
        if (mylivingPirates !=null){
            myPirates.add(mylivingPirates);
        }
    }
    
    /*
    *  do we repeat ourselves? 
    * @param n how many turns do you want to jump forward (use %2 numbers)
    */
    public boolean doWeRepeat(int repeatTimes,int n){
        //game.debug(myPirates);
        int repeatCounter = 0;
        Location nextNLocations = null;
        Location currentLocation = null;
        while (true){
            if (repeatCounter >= repeatTimes){
                myPirates = new ArrayList<>();
                return true;
            }else{
            for (int i = 0; i < myPirates.size(); i++) {
                for (Pirate currentPirate : myPirates.get(i)){
                    currentLocation = currentPirate.location;
                    if (i+n < myPirates.size()){
                        for (Pirate nextPirate : myPirates.get(i+n)){
                            nextNLocations = nextPirate.location;
                            if (currentLocation.col == nextNLocations.col && currentLocation.row == nextNLocations.row){
                                repeatCounter++;
                                //game.debug("counter: " + repeatCounter);
                                break;
                            }
                        }
                    }
                    if (repeatCounter >= repeatTimes){
                        myPirates = new ArrayList<>();
                        return true;
                    }
                    
                }
            }
                
            }
            game.debug("false");
            return false;
        }
    }
}
/*





package bots;

import pirates.*;

import java.util.*;

class History {

    private ArrayList<List<Pirate>> enemyPirates = new ArrayList<>();

    private List<List<Location>> enemysPiratesLocation;

    private List<List<Integer>> enemysPiratesHealth;

    public History(PirateGame game)


    {
        enemysPiratesLocation = new ArrayList<>();
        enemysPiratesHealth = new ArrayList<>();

    }

    public History() {
        
    }


    void update(PirateGame game)


    {
        enemysPiratesLocation.add(new ArrayList<>());
        enemysPiratesHealth.add(new ArrayList<>());
        List<Location> thisTurnEnemyPiratesLocations = enemysPiratesLocation.get(enemysPiratesLocation.size() - 1);
        List<Integer> thisTurnEnemyPiratesHealth = enemysPiratesHealth.get(enemysPiratesLocation.size() - 1);
        for (Pirate pirate : game.getEnemyLivingPirates()) {
            thisTurnEnemyPiratesLocations.add(new Location(pirate.location.row, pirate.location.col));//create copy
            thisTurnEnemyPiratesHealth.add(pirate.currentHealth);


        }
        enemyPirates.add(game.getAllEnemyPirates());

    }


    public List<Location> getEnemyPiratesLocatin(int turn)//return copy


    {
        List<Location> copy = new ArrayList<>();
        for (Location l : enemysPiratesLocation.get(turn)) {
            copy.add(l);

        }
        return copy;
    }


    public List<Integer> getEnemyPiratesHealth(int turn)//return copy


    {
        List<Integer> copy = new ArrayList<>();
        for (Integer i : enemysPiratesHealth.get(turn)) {
            copy.add(i);

        }
        return copy;

    }


    public ArrayList<List<Pirate>> getEnemyPirates() {
        return enemyPirates;
    }

    private boolean isEnemyPirateStateNothing(PirateGame game, Pirate pirate) {
        int id = getPirateId(game, pirate);
        for (List<Pirate> enemyPirate : enemyPirates) {
            if (enemyPirate.get(id).getLocation().compareTo(enemyPirate.get(id).initialLocation) != 0) {
                return false;
            }
        }
        game.debug("true");
        return true;


    }


    private int getPirateId(PirateGame game, Pirate pirate) {
        int id = 0;
        for (List<Pirate> pirateList : enemyPirates) {
            for (Pirate p : pirateList) {
                if (p.id == pirate.id) {
                    id = p.id;
                }
            }
            return id;
        }
        return id;
    }
}



//this one works- 
package bots;
import pirates.*;


import java.util.*;

class History {
    static ArrayList<List<Pirate>> enemyPirates;
    void update(PirateGame game) {
        //enemyPirates.add(game.getTurn(),game.getAllEnemyPirates());
    }
}
*/
