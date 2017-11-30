package refactor_jdbc_review.domian;


public class Student {

    private int id;
    private String name;
    private String department;
    private int score;

    public int getId(){

        return this.id;
    }

    public void setId(int id){

        this.id = id;
    }

    //Name
    public void setName(String name){

        this.name = name;

    }

    public String getName(){

        return this.name;
    }

    //department
    public void setDepartment(String department){

        this.department = department;

    }

    public String getDepartment(){

        return this.department;
    }

    //score
    public void setScore(int score){

        this.score = score;
    }

    public int getScore(){

        return this.score;
    }


    @Override
    public String toString(){

        return "{id="+id+",name="+this.name+",department="+department+",score="+this.score;
    }

    public Student(String name,String department,int score){

        this.name = name;
        this.department = department;
        this.score = score;
    }
    public Student(String name,String department,int score,int id){
        this(name,department,score);

        this.id=id;

    }
    public Student(){};

}
