package com.antworks.txtprocessor

/**
  * Created by Dennis Saka on 2018/04/30.
  *
  * Trait responsible for reading/loading Users and Tweets.
  *
  */
trait UserTweetFileReader {

  /**
    * @return A [[String]] containing all the users.
    */
  def stringsFromUserFile: String
  /**
    * @return A [[Seq]] containing all the users and their tweets.
    */
  def stringsFromTweetFile: Seq[String]
}
