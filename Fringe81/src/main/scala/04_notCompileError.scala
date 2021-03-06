// わかっていること
// Mapのget methodはOption型で返す
// mOptで返ってくるのではOption(Map[Int, String])
// mOpt.get(1)で使っているgetはOptionのgetである(3とかいれるとNoSuchElementExceptionが返ってくる)

object NotCompileError {
  def main(args: Array[String]): Unit = {
    val m = Map(1->"one", 2->"two")
    val mOpt: Option[Map[Int, String]] = Some(m)

    println(mOpt.get.apply(1))  // return one
    println(mOpt.get)     // equal m
    println(m.apply(1))         // m(1) == "one"
  }
}

// Option(A).get => A
// Map(B->C).get(B) => Option(C)
//
// Option(Map(B->C)).get => Map(B->C)
// Map(B->C).get(B) => Option(C)
// Option(C).get => C
//
// Option(Map(B->C)).get(B) => C


