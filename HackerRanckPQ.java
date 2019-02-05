import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */ 
    class Student {
        private int id;
        private String name;
        private double CGPA;
        
        Student(int id, String name, double CGPA) {
            this.id = id;
            this.name = name;
            this.CGPA = CGPA;
        }
        
        public int getID() {
            return this.id;
        }
        
        public String getName() {
            return this.name;
        }
        
        public double getCGPA() {
            return this.CGPA;
        }       
    }

class Priorities {
    List<Student> getStudents(List<String> events) {
        
        PriorityQueue<Student> pq = new PriorityQueue<Student>(events.size(),new Comparator<Student>(){
                  @Override
    public int compare(Student s1, Student s2) {
            if(s2.getCGPA() > s1.getCGPA()) {
                return 1;
            } else if(s1.getCGPA() == s2.getCGPA())  {
                if(!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                } else {
                    return s1.getID() - s2.getID();
                }
            } else {
                return 0;
            }
         }
     });
        List<Student> result = new ArrayList();
        Iterator<String> itr = events.iterator();
        while(itr.next() != null) {
            if(itr.next().contains("ENTER")) {
                String[] event = itr.next().split(" ");
                Student student = new             Student(Integer.parseInt(event[1]),event[2],Double.parseDouble(event[3]));
                result.add(student);
                for(Student stud: result) {
                    pq.offer(stud);
                }               
            } else{             
                while(!pq.isEmpty()) {
                    pq.poll();
                } 
            }
        }
        return result;
    }
}

 class HackerRankPQ {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
