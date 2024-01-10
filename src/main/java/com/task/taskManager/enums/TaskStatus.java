package com.task.taskManager.enums;

public enum TaskStatus {

    IN_PROGRESS(1),
    COMPLETED(2),
    LATE(3);

private int code;

private TaskStatus (int code){
    this.code = code;
}

public int getCode(){
    return code;
}

public static TaskStatus valueOf(int code){
      for(TaskStatus status : TaskStatus.values()){
          if(status.getCode() == code){
              return status;
          }
      }
      throw new IllegalArgumentException("Invalid Task status!");
}



}
