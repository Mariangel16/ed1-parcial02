package ed.lab;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

public class E01MeetingRooms {

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) return 0;

        // Ordenar por hora de inicio
        meetingIntervals.sort(Comparator.comparingInt(MeetingInterval::startTime));

        // Min Heap para almacenar tiempos de finalización
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (MeetingInterval interval : meetingIntervals) {
            // Si la sala más temprana está libre, se reutilizara
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.startTime()) {
                minHeap.poll();
            }
            // Reservar una sala
            minHeap.add(interval.endTime());
        }

        // El tamaño del heap indica cuántas salas se están usando en paralelo
        return minHeap.size();
        //
    }
}
