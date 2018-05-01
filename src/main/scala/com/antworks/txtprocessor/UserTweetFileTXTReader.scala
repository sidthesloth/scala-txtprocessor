package com.antworks.txtprocessor

import scala.io.Source

/**
  * Created by Dennis Saka on 2018/04/30.
  *
  * Implementation of [[UserTweetFileReader]] responsible for reading lines from a TXT files.
  *
  * @param fileName The name of the TXT file to be read.
  *
  */
class UserTweetFileTXTReader(val fileName: String) extends UserTweetFileReader {

  override def stringsFromUserFile: String = {
    val lines : String = Source.fromFile(fileName).getLines.mkString(" ")
    lines
  }

  def stringsFromTweetFile: Seq[String]= {
    val bufferedSource = Source.fromFile(fileName)
    val lines = (for {
      line <- bufferedSource.getLines()
    } yield line).toList
    bufferedSource.close
    lines
  }
}


