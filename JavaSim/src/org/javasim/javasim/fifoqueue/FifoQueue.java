package org.javasim.javasim.fifoqueue;

import java.util.Collection;

import org.javasim.ctstat.CTStat;

/**
 * This is a generic FIFO Queue object that
 * also keeps track of statistics on the number in queue (WIP)
 * Last update 6/28/2010
 */



Private ThisQueue As New Collection
Dim WIP As New CTStat
Private Sub Class_Initialize()
' Executes when FIFOQueue object is created to add queue statistics
' to TheCTStats collection
    
    TheCTStats.Add WIP
End Sub
Function NumQueue() As Integer
' Return current number in queue

    NumQueue = ThisQueue.Count
End Function
Public Sub Add(ThisEntity As Object)
' Add an entity to the end of the queue

    If ThisQueue.Count = 0 Then
        ThisQueue.Add ThisEntity
    Else
        ThisQueue.Add ThisEntity, After:=ThisQueue.Count
    End If
    WIP.Record ThisQueue.Count
End Sub
Public Function Remove() As Object
' Remove the first entity from the queue and return the object
' after updating queue statistics

    If ThisQueue.Count > 0 Then
        Set Remove = ThisQueue.Item(1)
        ThisQueue.Remove 1
    End If
    WIP.Record ThisQueue.Count
End Function

Public Function Mean() As Double
'Return the average number in queue up to the current time

    Mean = WIP.Mean
End Function



public class FifoQueue {
      private Collection<Object> thisQueue;
      CTStat wip;
      
      /**
       * Executes when FIFOQueue object is created to add queue statistics
       * to TheCTStats collection
       */
      private void classInitialize(Collection<CTStat> theCtStats) {
        theCtStats.add(wip);
      }
      
      public FifoQueue() {
        
      }
}
