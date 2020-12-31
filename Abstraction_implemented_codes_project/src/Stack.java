/* Programmer's Manual - Stack Of S_Contents
This stack holds any primitive data
Accessing push method -- <ObjectIdentifier>.push(Object)
Accessing pop method -- <ObjectIdentifier>.pop()
Accessing getData method -- <ObjectIdentifier>.getData() returns ArrayList of Object
 */

import java.util.ArrayList;
import java.util.Collection;

public class Stack {
    private int MaxSize;
    private S_Contents[] ArrayStack;
    private int TopOfStackPointer;
    private int FreeStackPointer;
    // the Create Stack method
    Stack(int idx) {
        MaxSize = idx;
        ArrayStack = new S_Contents[MaxSize];
        for (int Index = 0; Index <= MaxSize - 1; Index++) {
            ArrayStack[Index] = new S_Contents();
            ArrayStack[Index].Data = "";
            ArrayStack[Index].Pointer = Index + 1;
        }
        ArrayStack[MaxSize-1].Pointer = -1;
        TopOfStackPointer = -1;
        FreeStackPointer = 0;
    }

    // the add element method
    public void Push(Object NewValue) {
        if (FreeStackPointer == -1) {
            System.out.println("**The stack is full**");
        } else {
            int TempPointer;
            TempPointer = FreeStackPointer;
            ArrayStack[FreeStackPointer].Data = NewValue;
            FreeStackPointer = ArrayStack[FreeStackPointer].Pointer;
            ArrayStack[TempPointer].Pointer = TopOfStackPointer;
            TopOfStackPointer = TempPointer;
        }
    }

    // the remove element method
    public void Pop() {
        if (TopOfStackPointer == -1) {
            System.out.println("**The stack is empty**");
        } else {
            int TempPointer;
            TempPointer = FreeStackPointer;
            System.out.println(ArrayStack[TopOfStackPointer].Data + "   -- removed ");
            ArrayStack[TopOfStackPointer].Data = "";
            FreeStackPointer = TopOfStackPointer;
            TopOfStackPointer = ArrayStack[TopOfStackPointer].Pointer;
            ArrayStack[FreeStackPointer].Pointer = TempPointer;
        }
    }

    // the fetch elements method
    public Collection<Object> getData() {
        Collection<Object> ElementStack = new ArrayList<>();
        if (TopOfStackPointer != -1) {
            ElementStack.add(ArrayStack[TopOfStackPointer].Data);
            int CurrentStackPointer;
            CurrentStackPointer = ArrayStack[TopOfStackPointer].Pointer;
            while (CurrentStackPointer != -1) {
                ElementStack.add(ArrayStack[CurrentStackPointer].Data);
                CurrentStackPointer = ArrayStack[CurrentStackPointer].Pointer;
            }
        }
        return ElementStack;
    }
}















