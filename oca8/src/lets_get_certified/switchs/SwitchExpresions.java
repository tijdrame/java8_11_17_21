package lets_get_certified.switchs;

enum Direction {NORTH, SOUTH, EAST, WEST}

public class SwitchExpresions {
    public static void main(String[] args) {
        Direction d = Direction.NORTH;
        // switch statement (fall-through => requires 'break')
        int numLetters = 0;
        switch (d) {
            case NORTH :
            case SOUTH:
                numLetters = 5;
                break;
            case EAST:
            case WEST:
                numLetters = 4;
                break;
        }
        System.out.println(numLetters);

        /**
         * since java 14:
         *  - use of the ->
         *  - no fall-through logic
         *  - case labels must cover all values (insert 'default')
         *  les labels qui ont ':' requiert break or yield pour eviter les bugs
         */
        System.out.println(
                switch (d){
                    case NORTH, SOUTH -> 5;
                    default -> 4;
                    /*case NORTH, SOUTH: yield 5;//'yield' came in java 13
                    default: yield 4;*/
                });
    }
}
