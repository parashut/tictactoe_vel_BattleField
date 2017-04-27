package model;


public class Grid {
    private Sign[] grid = new Sign[9];

    public void setSignOnGrid(int position, Sign sign){
        if (isEmptyPosition(position)){
            grid[position] = sign;
        }
    }

    public void resetSignOnGrid(int position){
        grid[position] = null;
    }

    public boolean isEmptyPosition(int position){
        return grid[position] == null;
    }

    public Sign signOnPosition(int pos){
        return grid[pos];
    }

    public Sign[] getGrid() {
        return grid;
    }
}


