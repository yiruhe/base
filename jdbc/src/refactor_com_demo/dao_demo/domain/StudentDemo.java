package refactor_com_demo.dao_demo.domain;


public class StudentDemo {

    private Integer id;
    private String name;
    private String department;
    private Integer score;


    public Integer getId(){


        return this.id;
    }

    public void setId(Integer id){

        this.id = id;

    }

    public String getName(){


        return this.name;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getDepartment(){


        return this.department;

    }

    public void setDepartment(String department){

        this.department = department;

    }


    public Integer getScore(){


        return this.score;
    }


    public void setScore(Integer score){


        this.score = score;
    }


    @Override
    public String toString(){


        return this.id+", Name="+this.name+", score="+this.score+", department="+this.department;

    }



    public StudentDemo(){


    }

    public StudentDemo(Integer id,String name,String department,Integer score){

        this.id = id;
        this.name = name;
        this.department = department;
        this.score = score;

    }




}
