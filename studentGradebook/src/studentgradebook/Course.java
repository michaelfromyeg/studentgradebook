package studentgradebook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Course implements java.io.Serializable {

	public String courseName;
	public String location;
	public String teacher;
	public static ArrayList<Test> tests = new ArrayList<Test>();
        
	public Course(String courseName, String location, String teacher) {
            this.courseName = courseName;
            this.location = location;
            this.teacher = teacher;
            Course.tests = new ArrayList<>();
	}
	
	public String getCourseName() {
            return this.courseName;
	}
	
	public void setCourseName(String newCourseName) {
            this.courseName = newCourseName;
	}
	
	public String getLocation() {
            return this.location;
	}
	
	public void setLocation(String newLocation) {
            this.location = newLocation;
	}

	public String getTeacher() {
            return this.teacher;
	}
	
	public void setTeacher(String newTeacher) {
            this.teacher = newTeacher;
	}
	
        public void addTest(Test test) {
            tests.add(test);
        }
        
        public void deleteTest(Test test) {
            int index = tests.indexOf(test);
                if (index == -1) {
                    System.out.print("Test not found!");
                }
                else {
                    tests.remove(index);
                }
        }
 
        public double weightSum() { 
            double weightSum = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightSum += this.tests.get(i).getTestWeighting() / 100;
            }            
            return weightSum;
        }
        
        public double classAverage() {     
            double weightedAvg = 0.0;
            
            for(int i = 0; i < tests.size(); i++) {
                weightedAvg += (this.tests.get(i).getTestWeighting() / 100) * this.tests.get(i).getTestScore();
            }
            return weightedAvg / this.weightSum();
        }
        
        @Override
        public String toString() {
            return "This course is called: " + this.getCourseName();
        }
}
