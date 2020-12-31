/* Programmer's Manual - LinkedList of S_Contents
This LinkedList holds any primitive data
Accessing Add method -- <ObjectIdentifier>.Add(Object)
Accessing Remove method -- <ObjectIdentifier>.Remove(Object)
Accessing Search method -- <ObjectIdentifier>.Search(Integer) returns Object
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class LinkedList {
    private int MaxSize;
    private S_Contents[] ArrayLinkedList;
    private int HeadNode, FreeNode;

    // the create method
    LinkedList(int idx) {
        MaxSize = idx;
        ArrayLinkedList = new S_Contents[MaxSize];
        for (int Index = 0; Index < MaxSize; Index++) {
            ArrayLinkedList[Index] = new S_Contents();
            ArrayLinkedList[Index].Data = "";
            ArrayLinkedList[Index].Pointer = Index + 1;
        }
        ArrayLinkedList[MaxSize - 1].Pointer = -1;
        HeadNode = -1;
        FreeNode = 0;
    }

    // the add element method
    public void Add(Object NewValue) {
        if (FreeNode == -1) {
            System.out.println("**The linked list is full**");
        } else {
            int TempPointer = FreeNode;
            ArrayLinkedList[FreeNode].Data = NewValue;
            FreeNode = ArrayLinkedList[FreeNode].Pointer;
            ArrayLinkedList[TempPointer].Pointer = HeadNode;
            HeadNode = TempPointer;
        }
    }

    // the remove node method
    public void Remove(Object ValueToRemove) {
        int TempPointer = HeadNode;
        int PreviousNode = -1;
        boolean retFlag = true;
        while (retFlag == true && TempPointer != -1) {
            if (ArrayLinkedList[TempPointer].Data == ValueToRemove) {
                retFlag = false;
            } else {
                PreviousNode = TempPointer;
                TempPointer = ArrayLinkedList[TempPointer].Pointer;
            }
        }
        if (HeadNode == -1) {
            System.out.println("**The LinkedList is empty**");
        } else if (retFlag == true) {
            System.out.println("**No such element**");
        } else {
            if (PreviousNode == -1) {
                HeadNode = -1;
            } else {
                ArrayLinkedList[PreviousNode].Pointer = ArrayLinkedList[TempPointer].Pointer;
            }
            ArrayLinkedList[TempPointer].Pointer = FreeNode;
            FreeNode = TempPointer;
        }
    }

    // the search element index method
    public Collection<Object> getData() {
        Collection<Object> ElementLinkedList = new ArrayList<>();
        if (HeadNode != -1) {
            ElementLinkedList.add(ArrayLinkedList[HeadNode].Data);
            int CurrentPointer;
            CurrentPointer = ArrayLinkedList[HeadNode].Pointer;
            while (CurrentPointer != -1) {
                ElementLinkedList.add(ArrayLinkedList[CurrentPointer].Data);
                CurrentPointer = ArrayLinkedList[CurrentPointer].Pointer;
            }
        }
        return ElementLinkedList;
    }
}