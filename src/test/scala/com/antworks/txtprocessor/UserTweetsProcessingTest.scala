package com.antworks.txtprocessor

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by Dennis Saka on 2018/04/30.
  */
class UserTweetsProcessingTest extends FunSuite with BeforeAndAfter {

  val userStringFromFile = new UserTweetFileTXTReader("src/main/resources/user.txt").stringsFromUserFile
  var tweetsAndUserListFromFile = new UserTweetFileTXTReader("src/main/resources/tweet.txt").stringsFromTweetFile

  before {
//    var tweetsAndUserListFromFile = new UserTweetFileTXTReader("src/main/resources/user.txt")
//    val userStringFromFile = new UserTweetFileTXTReader("src/main/resources/user.txt").stringsFromUserFile
  }


  test("build users with empty tweets") {
    assert(UserTweetsProcessing.buildUsersWithEmptyTweets(userStringFromFile) === List(("Ward",""), ("Alan",""), ("Martin",""), ("wade",""), ("Daniel",""), ("freddie","")))
  }

  test("create multimap of user and their tweets") {

    UserTweetsProcessing.nodes = Map.empty[String, List[String]]
    val key = "Ward"
    val value = "There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors."
    assert(UserTweetsProcessing.addNode(key, value) === (():Unit))
  }

  test("map user and tweet  ") {

    assert(UserTweetsProcessing.userTweetMap(tweetsAndUserListFromFile, userStringFromFile) === (():Unit))
  }
  test("Display users and tweets ") {
    UserTweetsProcessing.nodes = Map("wade" -> List(), "Ward" -> List(", There are only two hard things in Computer Science: cache invalidation, naming things and off-by-1 errors."), "Alan" -> List(", Random numbers should not be generated with a method chosen at random., If you have a procedure with 10 parameters, you probably missed some."), "freddie" -> List(), "Daniel" -> List(", Random numbers should not be generated with a method chosen at random."), "Martin" -> List())
    assert(UserTweetsProcessing.displayUsersAndTweet === (():Unit))
  }
}
