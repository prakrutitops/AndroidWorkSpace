class trycatchfinallyEx
{
    fun ans()
    {
        try
        {
            var num =10/0
            println(num)
        }
      catch (e:Exception)
      {
          println(e)
      }
        finally {
            println("Executed")
        }


    }
}
fun main()
{
    var t=trycatchfinallyEx()
    t.ans()
}