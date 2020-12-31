/* Programmer's Manual - CircularQueue of S_Contents
This CircularQueue holds any primitive data
Accessing Insert method -- <ObjectIdentifier>.Insert(Object)
Accessing Remove method -- <ObjectIdentifier>.Remove()
Accessing getData method -- <ObjectIdentifier>.getData() returns ArrayList of Object
 */

import java.awt.font.TextMeasurer;
import java.util.ArrayList;
import java.util.Collection;

public class CircularQueue {
    private int MaxSize;
    private Object[] CircularQueue;
    private int StartPoint, EndPoint;
    // creating circular queue method
    CircularQueue(int idx){
      MaxSize = idx;
      CircularQueue = new Object[MaxSize];
      for (int Index=0; Index< MaxSize; Index++){
          CircularQueue[Index] = "";
      }
      StartPoint = -1;
      EndPoint = -1;
    }

    // the add element method
    public void Insert(Object NewValue){
        if (StartPoint == -1){
            StartPoint = 0; EndPoint = 0;
            CircularQueue[EndPoint] = NewValue;
        } else {
            int TempPoint = EndPoint;
            TempPoint += 1;
            if (TempPoint > MaxSize -1){
                TempPoint = 0;
            }
            if (TempPoint == StartPoint){
                System.out.println("**The queue is full**");
            } else {
                CircularQueue[TempPoint] = NewValue;
                EndPoint = TempPoint;
            }
        }
    }

    // the remove element method
    public void Remove(){
        if (StartPoint == -1){
            System.out.println("**The queue is empty**");
        } else {
            CircularQueue[StartPoint] = "";
            if (StartPoint == EndPoint){
                StartPoint = -1;
                EndPoint = -1;
            } else{
                StartPoint += 1;
                if (StartPoint > MaxSize -1){
                    StartPoint = 0;
                }
            }
        }
    }

    // the fetch elements method
    public Collection<Object> getData(){
        Collection<Object> CQueue = new ArrayList<>();
        if (StartPoint != -1){
            int TempPoint = StartPoint;
            while (TempPoint != EndPoint) {
                CQueue.add(CircularQueue[TempPoint]);
                TempPoint += 1;
                if (TempPoint > MaxSize - 1) {
                    TempPoint = 0;
                }
            }
            CQueue.add(CircularQueue[EndPoint]);
        }
        return CQueue;
    }
}
