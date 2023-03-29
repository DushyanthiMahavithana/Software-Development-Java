package com.company;

public class Queuelist {
    int size;
    int frontList,rearList;
    Passenger[] array;

    Queuelist(int size){
        frontList=-1;
        rearList=-1;
        this.size=size;
        this.array = new Passenger[size];
    }

    boolean fullQueue(){      //checking when queue is full
        if (frontList == 0 && rearList == size-1) {
            return true;
        }
        if (frontList == rearList + 1) {
            return true;
        }
        return false;
    }
    boolean emptyQueue() {          //checking when queue is empty
        if (frontList == -1)
            return true;
        else
            return false;
    }

    void addQueuelist(Passenger guest){      //adding passengers
        if (fullQueue()){
            System.out.println("Queue full");
        }else {
            if (frontList==-1)
                frontList=0;
            rearList=(rearList+1) % size;
            array[rearList] = guest;

        }
    }
    Passenger deleteQueuelist() {        //Deleting passengers
        Passenger guest = null;
        if (emptyQueue()) {
            return guest;
        } else {
            guest = array[frontList];
            if (frontList == rearList) {
                frontList = -1;
                rearList = -1;
            } else {
                frontList = (frontList + 1) % size; // check  elements,if it has only one  the array will reset
            }
            return guest;
        }
    }
}
