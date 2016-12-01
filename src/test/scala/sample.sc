def WHILE(condition: => Boolean)(command: => Unit): Unit = {
  if (condition) {
    command
    WHILE(condition)(command)
  } else ()
}
