/* Programmer's Manual - LinearQueue of S_Contents
This LinearQueue holds any primitive data
Accessing Insert method -- <ObjectIdentifier>.Insert(Object)
Accessing Remove method -- <ObjectIdentifier>.Remove()
Accessing getData method -- <ObjectIdentifier>.getData() returns ArrayList of Object
 */

import java.util.ArrayList;
import java.util.Collection;

public class LinearQueue {
    private int MaxSize;
    private S_Contents[] ArrayQueue;
    private int HeadOfQueue, TailOfQueue, FreeQueuePointer;
    // creating Linear Queue method
    LinearQueue(int idx){
        MaxSize = idx;
        ArrayQueue = new S_Contents[MaxSize];
        for (int Index=0; Index < MaxSize; Index++){
            ArrayQueue[Index] = new S_Contents();
            ArrayQueue[Index].Data = "";
            ArrayQueue[Index].Pointer = Index+1;
        }
        ArrayQueue[MaxSize-1].Pointer = -1;
        HeadOfQueue = -1;
        TailOfQueue = -1;
        FreeQueuePointer = 0;
    }
    // the add element method
    public void Insert(Object NewValue){
        if (FreeQueuePointer == -1){
            System.out.println("**The queue is full**");
        } else {
            int TempPointer = FreeQueuePointer;
            FreeQueuePointer = ArrayQueue[FreeQueuePointer].Pointer;
            ArrayQueue[TempPointer].Data = NewValue;
            if (HeadOfQueue == -1){
                HeadOfQueue = TempPointer;
            }
            if (TailOfQueue != -1){
                ArrayQueue[TailOfQueue].Pointer = TempPointer;
            }
            ArrayQueue[TempPointer].Pointer = -1;
            TailOfQueue = TempPointer;
        }
    }
    // the remove element method
    public void Remove(){
        if (HeadOfQueue == -1){
            System.out.println("**The queue is empty**");
        } else {
            int TempPointer = FreeQueuePointer;
            ArrayQueue[HeadOfQueue].Data = "";
            FreeQueuePointer = HeadOfQueue;
            HeadOfQueue = ArrayQueue[HeadOfQueue].Pointer;
            ArrayQueue[FreeQueuePointer].Pointer = TempPointer;
            if (HeadOfQueue == -1){
                TailOfQueue = -1;
            }
        }
    }
    // the  fetch element method
    public Collection<Object> getData() {
        Collection<Object> ElementQueue = new ArrayList<>();
        if (HeadOfQueue != -1) {
            int TempPointer = HeadOfQueue;
            while (TempPointer != -1) {
                ElementQueue.add(ArrayQueue[TempPointer].Data);
                TempPointer = ArrayQueue[TempPointer].Pointer;
            }
        }
        return ElementQueue;
    }
}
