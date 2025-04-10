import BreadthFirstSearch.Map;

public class Simulator {
    Map map = new Map();
    RenderConsoleMap renderConsoleMap = new RenderConsoleMap();
    Action initAction = new InitAction(map);
    Action turnAction = new TurnAction(map);

    public void nextTurn(){
        renderConsoleMap.render(map);
        turnAction.perform();
    }

    public void startSimulation(){
        initAction.perform();

        while (true){
            nextTurn();

            try {
                Thread.sleep(700);
            }catch (InterruptedException e){
                System.out.println(" Wait ");
            }
        }

    }
}
