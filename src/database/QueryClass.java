package database;

import java.util.Date;

import org.apache.hadoop.hdfs.server.namenode.status_jsp;

import java_cup.internal_error;

public class QueryClass {
	
	public static String SQLinsertUser(int user_id) {
		String SQLuser = "INSERT INTO users (`id`)" +
				 		 " VALUE (\"" + user_id + "\")" +
				 		 " ON DUPLICATE KEY UPDATE `id` = `id`;";
		return SQLuser;
	}
	
	public static String SQLupdateNumberPagerankCicleByUser(int user_id, int pagerank_cicle) {
		String SQL = "UPDATE movierecsys_db.users"
					+ " SET pagerank_cicle = " + pagerank_cicle
					+ " WHERE users.id = " + user_id + ";";		
		return SQL;
	}
	
	public static String SQLupdateDetailsRecMovieRequestByUser(int user_id, String movieURI, int number_recommendation_list, String details) {
		String SQL = "UPDATE movierecsys_db.ratings_rec_movies"
					+ " SET details = \"" + details + "\" "
					+ " WHERE `user_id` = \"" + user_id + "\" AND " +
					 "`movie_uri` = \"" + movieURI + "\" AND " +
					 "`number_recommendation_list` = \"" + number_recommendation_list + "\";";
		return SQL;
	}
	
	public static String SQLupdateWhyRecMovieRequestByUser(int user_id, String movieURI, int number_recommendation_list, String why) {
		String SQL = "UPDATE movierecsys_db.ratings_rec_movies"
					+ " SET why = \"" + why + "\" "
					+ " WHERE `user_id` = \"" + user_id + "\" AND " +
					 "`movie_uri` = \"" + movieURI + "\" AND " +
					 "`number_recommendation_list` = \"" + number_recommendation_list + "\";";
		return SQL;
	}

	public static String SQLupdateRefineRecMovieRatingByUser(int user_id, String movieURI, int number_recommendation_list, String refine) {
		String SQL = "UPDATE movierecsys_db.ratings_rec_movies"
					+ " SET refine = \"" + refine + "\" "
					+ " WHERE `user_id` = \"" + user_id + "\" AND " +
					 "`movie_uri` = \"" + movieURI + "\" AND " +
					 "`number_recommendation_list` = \"" + number_recommendation_list + "\";";
		return SQL;
	}
	public static String SQLupdateLikeRecMovieRatingByUser(int user_id, String movieURI, int number_recommendation_list, int like) {
		String SQL = "UPDATE movierecsys_db.ratings_rec_movies"
					+ " SET ratings_rec_movies.like = " + like
					+ " WHERE `user_id` = \"" + user_id + "\" AND " +
					 "`movie_uri` = \"" + movieURI + "\" AND " +
					 "`number_recommendation_list` = \"" + number_recommendation_list + "\";";
		return SQL;
	}
	public static String SQLupdateDislikeRecMovieRatingByUser(int user_id, String movieURI, int number_recommendation_list, int dislike) {
		String SQL = "UPDATE movierecsys_db.ratings_rec_movies"
					+ " SET ratings_rec_movies.dislike = " + dislike
					+ " WHERE `user_id` = \"" + user_id + "\" AND " +
					 "`movie_uri` = \"" + movieURI + "\" AND " +
					 "`number_recommendation_list` = \"" + number_recommendation_list + "\";";
		return SQL;
	}
	public static String SQLupdateRefocusRecMovieRatingByUser(int user_id, String movieURI, int number_recommendation_list, String refocus) {
		String SQL = "UPDATE movierecsys_db.ratings_rec_movies"
					+ " SET refocus = \"" + refocus + "\" "
					+ " WHERE `user_id` = \"" + user_id + "\" AND " +
					 "`movie_uri` = \"" + movieURI + "\" AND " +
					 "`number_recommendation_list` = \"" + number_recommendation_list + "\";";
		return SQL;
	}
	public static String SQLupdateNumberRecommendationListByUser(int user_id, int number_recommendation_list) {
		String SQL = "UPDATE movierecsys_db.users"
					+ " SET number_recommendation_list = " + number_recommendation_list
					+ " WHERE users.id = " + user_id + ";";		
		return SQL;
	}
	
	public static String SQLupdateLastChange(int user_id,String lastChange){
		String SQL = "UPDATE movierecsys_db.users "
				+ "SET last_change = \"" + lastChange + "\" "
				+ "WHERE users.id = " + user_id + ";";
		
		return SQL;
	}
	
	public static String SQLupdateReleaseYearFilter (int user_id, String propertyValue){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET release_year_filter = \"" + propertyValue + "\" "
					+ "WHERE users.id = " + user_id + ";";
		
		return SQL;
	}
	
	public static String SQLupdateRuntimeRangeFilter (int user_id, String propertyValue){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET runtime_range_filter = \"" + propertyValue + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}

	public static String SQLupdateBotName (int user_id, String botName){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET bot_name = \"" + botName + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}
	
	public static String SQLupdateAgeRange (int user_id, String ageRange){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET age = \"" + ageRange + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}

	public static String SQLupdateEducation (int user_id, String education){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET education = \"" + education + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}

	public static String SQLupdateGender (int user_id, String gender){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET gender = \"" + gender + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}

	public static String SQLupdateInterestInMovies (int user_id, String interestInMovies){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET interest_in_movies = \"" + interestInMovies + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}

	public static String SQLupdateUsedRecSys (int user_id, String usedRecSys){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET used_recommender_system = \"" + usedRecSys + "\" "
					+ "WHERE users.id = " + user_id + ";";

		return SQL;
	}
	public static String SQLinsertBotConfiguration(int user_id, String botName, int number_recommendation_list,int bot_timestamp){
		String SQL = "INSERT INTO `movierecsys_db`.`user_bot_configurations` (`user_id`, `bot_name`, `number_recommendation_list`, `bot_timestamp`)" +
					" VALUES (\"" + user_id + "\",\"" + botName + "\",\"" + number_recommendation_list + "\",\"" + bot_timestamp + "\")" +
					" ON DUPLICATE KEY UPDATE `bot_timestamp` = " + bot_timestamp + ";";
		
		return SQL;
	}
	

	public static String SQLinsertExperimentalSessionRating(int user_id, int number_recommendation_list, int rating, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_experimental_session` (`user_id`, `number_recommendation_list`, `rating`, `bot_name`)" +
					" VALUES (\"" + user_id + "\",\"" + number_recommendation_list + "\",\"" + rating + "\",\"" + botName + "\")" +
					" ON DUPLICATE KEY UPDATE `rating` = " + rating + ",`bot_name` = \"" + botName + "\";";
		return SQL;
	}
	
	public static String SQLinsertRatingAcceptRecMovies(int user_id, String movie_uri, int rating) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_accept_rec_movies` (`user_id`, `movie_uri`, `rating`)" +
					" VALUES (\"" + user_id + "\",\"" + movie_uri + "\",\"" + rating + "\")" +
					" ON DUPLICATE KEY UPDATE `rating` = " + rating + ";";
		return SQL;
	}
	//Non dovrebbe servire più
	public static String SQLinsertRecMovieRated (int user_id, String movieURI, int number_recommendation_list, int rating,int position,int pagerank_cicle, String refine,String refocus, String botName,int message_id, int bot_timestamp, String recommendatinsList,String ratingsList){
		//`user_id`, `movieURI`, `rating`, `position`, `pagerank_cicle`, `refineRefocus`, `botName`, `message_id`, `bot_timestamp`, `recommendatinsList`, `ratingsList`, `number_recommendation_list`
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_rec_movies` (`user_id`, `movie_uri`, `number_recommendation_list`, `rating`, `position`, `pagerank_cicle`, `refine`, `refocus`, `bot_name`, `message_id`, `bot_timestamp`, `recommendations_list`, `ratings_list`)" +
				" VALUES (\"" + user_id + "\",\"" + movieURI + "\",\"" + number_recommendation_list + "\",\"" + rating + "\",\"" + position + "\",\"" + pagerank_cicle + "\",\"" + refine + "\",\"" + refocus + "\",\"" + botName + "\",\"" + message_id + "\",\"" + bot_timestamp + "\",\"" + recommendatinsList + "\",\"" + ratingsList + "\",\")" +
				" ON DUPLICATE KEY UPDATE `rating` = " + rating + ",`refine` = \"" + refine + "\",`refocus` = \"" + refocus + "\";";
		return SQL;
	}

	public static String SQLinsertRecMovieToRating (int user_id, String movieURI, int number_recommendation_list, int position,int pagerank_cicle, String botName, int message_id, int bot_timestamp, int response_time, String recommendationListString){
		//`user_id`, `movieURI`, `rating`, `position`, `pagerank_cicle`, `refineRefocus`, `botName`, `message_id`, `bot_timestamp`, `recommendatinsList`, `ratingsList`, `number_recommendation_list`
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_rec_movies` (`user_id`, `movie_uri`, `number_recommendation_list`, `position`, `pagerank_cicle`, `bot_name`, `message_id`, `bot_timestamp`, `response_time`, recommendations_list)" +
				" VALUES (\"" + user_id + "\",\"" + movieURI + "\",\"" + number_recommendation_list + "\",\"" + position + "\",\"" + pagerank_cicle + "\",\"" + botName + "\",\"" + message_id + "\",\"" + bot_timestamp + "\",\"" + response_time + "\",\"" + recommendationListString + "\")" +
				" ON DUPLICATE KEY UPDATE `message_id` = " + message_id + ",`bot_timestamp` = " + bot_timestamp + ",`response_time` = " + response_time + ";";
		return SQL;
	}
		

	public static String SQLinsertRatingMovies(int user_id, String movie_uri, int rating, String lastChange,int number_recommendation_list, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_movies` (`user_id`, `movie_uri`, `rating`, `last_change`,`number_recommendation_list`, `bot_name`)" +
					" VALUES (\"" + user_id + "\",\"" + movie_uri + "\",\"" + rating + "\",\"" + lastChange + "\",\"" + number_recommendation_list + "\",\"" + botName + "\")" +
					" ON DUPLICATE KEY UPDATE `rating` = " + rating + ", `last_change` = \"" + lastChange + "\", `number_recommendation_list` = \"" + number_recommendation_list + "\", `bot_name` = \"" + botName + "\";";
		return SQL;
	}
	
	public static String SQLinsertRatingMoviesToLog(int user_id, String movie_uri, int rating, String lastChange,int number_recommendation_list, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_movies_log` (`user_id`, `movie_uri`, `rating`, `last_change`,`number_recommendation_list`, `bot_name`)" +
					" VALUES (\"" + user_id + "\",\"" + movie_uri + "\",\"" + rating + "\",\"" + lastChange + "\",\"" + number_recommendation_list + "\",\"" + botName + "\")" +
					" ON DUPLICATE KEY UPDATE `rating` = " + rating + ", `last_change` = \"" + lastChange + "\", `bot_name` = \"" + botName + "\";";
		return SQL;
	}
	
	public static String SQLinsertDetailsMovieRequest(int user_id, String movieURI, String details, int number_recommendation_list, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_movies` (`user_id`, `movie_uri`, `details`, `number_recommendation_list`, `bot_name`)" +
				" VALUES (\"" + user_id + "\",\"" + movieURI + "\",\"" + details + "\",\"" + number_recommendation_list + "\",\"" + botName + "\")" +
				" ON DUPLICATE KEY UPDATE `details` = \"" + details + "\", `number_recommendation_list` = \"" + number_recommendation_list + "\", `bot_name` = \"" + botName + "\";";		
		
		return SQL;
	}
	
	public static String SQLinsertDetailsMovieRequestLog(int user_id, String movieURI, String details, int number_recommendation_list, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_movies_log` (`user_id`, `movie_uri`, `details`, `number_recommendation_list`, `bot_name`)" +
				" VALUES (\"" + user_id + "\",\"" + movieURI + "\",\"" + details + "\",\"" + number_recommendation_list + "\",\"" + botName + "\")" +
				" ON DUPLICATE KEY UPDATE `details` = \"" + details + "\", `bot_name` = \"" + botName + "\";";		
		
		return SQL;
	}	
	
	public static String SQLinsertRatingProperties(int user_id, String propertyTypeURI, String propertyURI, int rating, String lastChange,int numberRecommendationList, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_properties` (`user_id`,  `property_type_uri`, `property_uri`, `rating`, `last_change`, `number_recommendation_list`, `bot_name`)" +
					" VALUES (\"" + user_id + "\",\"" + propertyTypeURI + "\",\"" + propertyURI + "\",\"" + rating + "\",\"" + lastChange + "\",\"" + numberRecommendationList + "\",\"" + botName + "\")" +
					" ON DUPLICATE KEY UPDATE `rating` = " + rating + ", `last_change` = \"" + lastChange + "\", `number_recommendation_list` = \"" + numberRecommendationList + "\", `bot_name` = \"" + botName + "\";";
		return SQL;
	}
	
	public static String SQLinsertRatingPropertiesLog(int user_id, String propertyTypeURI, String propertyURI, int rating, String lastChange,int numberRecommendationList, String botName) {
		String SQL = "INSERT INTO `movierecsys_db`.`ratings_properties_log` (`user_id`,  `property_type_uri`, `property_uri`, `rating`, `last_change`, `number_recommendation_list`, `bot_name`)" +
					" VALUES (\"" + user_id + "\",\"" + propertyTypeURI + "\",\"" + propertyURI + "\",\"" + rating + "\",\"" + lastChange + "\",\"" + numberRecommendationList + "\",\"" + botName + "\")" +
					" ON DUPLICATE KEY UPDATE `rating` = " + rating + ", `last_change` = \"" + lastChange + "\",`bot_name` = \"" + botName + "\";";
		return SQL;
	}
	
	public static String SQLinsertChatMessageToChatLog(int user_id, int message_id, String context, String replyText, String replyFuctionCall, int pagerank_cicle,int number_recommendation_list, String botName, int bot_timestamp, int response_time, String responseType, int number_rated_movies, int number_rated_properties){
		String SQL = "INSERT INTO `movierecsys_db`.`chat_log` (`chat_id`,  `message_id`, `context`, `reply_text`, `reply_function_call`,`pagerank_cicle`, `number_recommendation_list`, `bot_name`, `bot_timestamp`, `response_time`,`response_type`,`number_rated_movies`,`number_rated_properties`)" +
				" VALUES (\"" + user_id + "\",\"" + message_id + "\",\"" + context + "\",\"" + replyText + "\",\"" + replyFuctionCall + "\",\"" + pagerank_cicle + "\",\"" + number_recommendation_list + "\",\"" + botName + "\",\"" + bot_timestamp + "\",\"" + response_time + "\",\"" + responseType + "\",\"" + number_rated_movies + "\",\"" + number_rated_properties + "\");";
		
		return SQL;		
	}
	public static String SQLinsertChatMessage(int user_id, int message_id, String context, String replyText, String replyFuctionCall, int pagerank_cicle, int number_recommendation_list, String botName, int bot_timestamp, int response_time, String responseType, int number_rated_movies, int number_rated_properties){
		String SQL = "INSERT INTO `movierecsys_db`.`chats` (`chat_id`,  `message_id`, `context`, `reply_text`, `reply_function_call`,`pagerank_cicle`, `number_recommendation_list`, `bot_name`,`bot_timestamp`,`response_time`,`response_type`,`number_rated_movies`,`number_rated_properties`)" +
				" VALUES (\"" + user_id + "\",\"" + message_id + "\",\"" + context + "\",\"" + replyText + "\",\"" + replyFuctionCall + "\",\"" + pagerank_cicle + "\",\"" + number_recommendation_list + "\",\"" + botName + "\",\"" + bot_timestamp + "\",\"" + response_time + "\",\"" + responseType + "\",\"" + number_rated_movies + "\",\"" + number_rated_properties + "\");";
		
		return SQL;		
	}
	
	public static String SQLinsertUserDetail(int user_id, String firstname, String lastname, String user_name){
		String SQL = "INSERT INTO `movierecsys_db`.`users` (`id`, `firstname`,`lastname`,`username`)" +
				" VALUES (\"" + user_id + "\",\"" + firstname + "\",\"" + lastname + "\",\"" + user_name + "\")" +
				" ON DUPLICATE KEY UPDATE `firstname` = \"" + firstname + "\", `lastname` = \"" + lastname + "\",`username` = \"" + user_name + "\";";
		return SQL;
	}
	
	public static String SQLinsertScoresRecMovies(int user_id, String movieURI, String propertyTypeURI, String propertyURI,double propertyScore){
		String SQL = "INSERT INTO `movierecsys_db`.`scores_rec_movies` "
				+ "(`user_id`, `movie_uri`,`property_type_uri`,`property_uri`,`score`)" +
				" VALUES (\"" + user_id + "\",\"" + movieURI + "\",\"" + propertyTypeURI + "\",\"" + propertyURI + "\",\"" + propertyScore + "\")" +
				" ON DUPLICATE KEY UPDATE `score` = " + propertyScore + ";";
		
		return SQL;
	}
	
	public static String SQLinsertScoresUserMovies(int user_id, String movieURI, String propertyTypeURI, String propertyURI,double propertyScore){
		String SQL = "INSERT INTO `movierecsys_db`.`scores_user_movies` "
				+ "(`user_id`, `movie_uri`,`property_type_uri`,`property_uri`,`score`)" +
				" VALUES (\"" + user_id + "\",\"" + movieURI + "\",\"" + propertyTypeURI + "\",\"" + propertyURI + "\",\"" + propertyScore + "\")" +
				" ON DUPLICATE KEY UPDATE `score` = " + propertyScore + ";";
		
		return SQL;
	}
	
	public static String SQLinsertScoresUserProperties(int user_id, String propertyTypeURI, String propertyURI, double propertyScore){
		String SQL = "INSERT INTO `movierecsys_db`.`scores_user_properties` "
				+ "(`user_id`,`property_type_uri`,`property_uri`,`score`)" +
				" VALUES (\"" + user_id + "\",\"" + propertyTypeURI + "\",\"" + propertyURI + "\",\"" + propertyScore + "\")" +
				" ON DUPLICATE KEY UPDATE `score` = " + propertyScore + ";";
		
		return SQL;
	}
	
	public static String SQLinsertVertexPosterSelection(String vertexString, double vertexScore){
		String SQL = "INSERT INTO `movierecsys_db`.`vertices_poster_selection` "
				+ "(`uri`, `score`)" +
				" VALUES (\"" + vertexString + "\",\"" + vertexScore + "\")" +
				" ON DUPLICATE KEY UPDATE `score` = " + vertexScore + ";";
		
		return SQL;
	}
	
	public static String SQLinsertVertexTrailerSelection(String vertexString, double vertexScore){
		String SQL = "INSERT INTO `movierecsys_db`.`vertices_trailer_selection` "
				+ "(`uri`, `score`)" +
				" VALUES (\"" + vertexString + "\",\"" + vertexScore + "\")" +
				" ON DUPLICATE KEY UPDATE `score` = " + vertexScore + ";";
		
		return SQL;
	}
	
	//public static String 
	
	public static String SQLupdateNumberRatedMoviesByUser (int user_id){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET rated_movies = "
					+ "(SELECT COUNT(*) FROM movierecsys_db.ratings_movies "
						+ "WHERE ratings_movies.user_id = users.id "
						+ "AND (ratings_movies.rating = 0 "
						+ "OR ratings_movies.rating = 1)) "
					+ "WHERE users.id = " + user_id + ";";
		return SQL;
	}

	public static String SQLupdateNumberRatedPropertiesByUser (int user_id){
		String SQL = "UPDATE movierecsys_db.users "
					+ "SET rated_properties = "
					+ "(SELECT COUNT(*) FROM movierecsys_db.ratings_properties "
						+ "WHERE ratings_properties.user_id = users.id "
						+ "AND ratings_properties.last_change = \"user\" "
						+ "AND (ratings_properties.rating = 0 "
						+ "OR ratings_properties.rating = 1)) "
					+ "WHERE users.id = " + user_id + ";";
		return SQL;
	}

	//NON usata
	public static String SQLupdatePropertiesScores(int user_id, String movieURI, String propertyTypeURI, String propertyURI,double propertyScore){
		String SQL = "UPDATE `movierecsys_db`.`scores_rec_movies` " +
				 " SET `user_id` = \"" + user_id + "\","+
				 "`movie_uri` = \"" + movieURI + "\"," +
				 "`property_type_uri` = \"" + propertyTypeURI + "\"," +
				 "`property_uri` = \"" + propertyURI + "\"," +
				 "`score` = \"" + propertyScore + "\"," +
				 " WHERE `user_id` = \"" + user_id + "\" AND " +
				 "`movie_uri` = \"" + movieURI + "\" AND " +
				 "`property_type_uri` = \"" + propertyTypeURI + "\" AND " +
				 "`property_uri` = \"" + propertyURI + "\";";
		
		return SQL;
	}
	
	public static String SQLupdateUserDetailToNullByUser(int user_id){
		String SQL =	"UPDATE users "
						+ "SET age = NULL, "
							+ "gender = NULL, "
							+ "education = NULL, "
							+ "interest_in_movies = NULL, "
							+ "used_recommender_system = NULL, "
							+ "bot_name = NULL "
						+ "WHERE `id` = " + user_id + ";";
		
		return SQL;
	}

	public static String SQLdeleteAllScoreByUserFromScoresRecMovies(int user_id) {
		String SQL = 	"DELETE FROM `movierecsys_db`.`scores_rec_movies`"
						+ 	" WHERE `user_id` = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLdeleteAllScoreByUserFromScoresUserMovies(int user_id) {
		String SQL = 	"DELETE FROM `movierecsys_db`.`scores_user_movies`"
						+ 	" WHERE `user_id` = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLdeleteAllScoreByUserFromScoresUserProperties(int user_id) {
		String SQL = 	"DELETE FROM `movierecsys_db`.`scores_user_properties`"
						+ 	" WHERE `user_id` = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLdeleteAllPropertyRatedByUser(int user_id) {
		String SQL = 	"DELETE FROM `movierecsys_db`.`ratings_properties`"
						+ " WHERE `user_id` = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLdeleteAllMovieRatedByUser(int user_id) {
		String SQL = 	"DELETE FROM `movierecsys_db`.`ratings_movies`"
						+ " WHERE `user_id` = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLdeleteAllChatMessageByUser(int user_id){
		String SQL =	"DELETE FROM `movierecsys_db`.`chats`"
					  + " WHERE `chat_id` = " + user_id + ";";
		
		return SQL;
	}

	public static String SQLselectNumberRefineFromRecMovieListByUserAndRecList(int user_id, int numberRecommendationList) {
		String SQL = 	"SELECT COUNT(*) as number_refine_rec_movie "
						+ "FROM ratings_rec_movies "
						+ "WHERE number_recommendation_list = " + numberRecommendationList + " "
						+ "AND user_id = " + user_id + " "
						+ "AND ratings_rec_movies.refine = \"refine\";";
		return SQL;
	}
	
	//conta il numero di like e dislike dei film raccomandati (e anche refine)
	public static String SQLselectNumberRatedRecMovieByUserAndRecListByUser(int user_id, int numberRecommendationList) {
		String SQL = 	"SELECT COUNT(*) as number_rated_rec_movie "
						+ "FROM ratings_rec_movies "
						+ "WHERE number_recommendation_list = " + numberRecommendationList + " "
						+ "AND user_id = " + user_id + " "
						+ "AND ((ratings_rec_movies.like = 1 "
						+ "OR ratings_rec_movies.dislike = 1) OR ratings_rec_movies.refine = \"refine\");";
		return SQL;
	}
	
	//conta le configurazioni del bot assegnate
	public static String SQLselectNumberOfBotNameByBotName(String botName) {
		String SQL = 	"SELECT COUNT(*) as number_bot_name"
						+ " FROM users"
						+ " WHERE bot_name = \"" + botName + "\";";
		return SQL;
	}

	public static String SQLselectNumberOfRatedMoviesByUser(int user_id) {
		String SQL = 	"SELECT rated_movies "
						+ "FROM movierecsys_db.users "
						+ "WHERE id = " + user_id + ";";
		return SQL;
	}
		
	public static String SQLselectNumberOfRatedPropertiesByUser(int user_id) {
		String SQL = 	"SELECT rated_properties "
						+ "FROM movierecsys_db.users "
						+ "WHERE id = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLselectNumberOfPagerankCicleByUser(int user_id) {
		String SQL = 	"SELECT pagerank_cicle "
						+ "FROM movierecsys_db.users "
						+ "WHERE id = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLselectNumberRecommendationListByUserByUser(int user_id) {
		String SQL = 	"SELECT number_recommendation_list "
						+ "FROM movierecsys_db.users "
						+ "WHERE id = " + user_id + ";";
		return SQL;
	}

	public static String SQLselectLastChangeByUser(int user_id) {
		String SQL = 	"SELECT last_change "
						+ "FROM movierecsys_db.users "
						+ "WHERE id = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLselectLastBotTimestamp(int user_id){
		String SQL = "SELECT bot_timestamp FROM chat_log "
					+ "WHERE chat_id = " + user_id + " "
					+ "ORDER BY id DESC LIMIT 1;";
		
		return SQL;
	}
	
	public static String SQLselectBotTimestampFromRatingsRecMovies(int user_id, int number_recommendation_list, int position){
		String SQL = "SELECT bot_timestamp "
					+ "FROM movierecsys_db.ratings_rec_movies "
					+ "WHERE user_id = " + user_id + " "
					+ "AND number_recommendation_list = " + number_recommendation_list + " "
					+ "AND position = " + position + " ;";
				
	 	return SQL;
	}

	public static String SQLselectAllMovies() {
		String SQL = 	"SELECT uri,title FROM movies" +
						" WHERE `poster` != \"N/A\";";
		return SQL;
	}
	
	public static String SQLselectResourceUriFromDbpediaMoviesSelection(String uri){
		String SQL = "SELECT * FROM movierecsys_db.mapping_dbpedia_movies_poster_selection"
				+ " WHERE  \"" + uri + "\" IN (subject,predicate,object) limit 1;";
		
		return SQL;
	}
	
	public static String SQLselectUserDetalByUser(int user_id){
		String SQL = "SELECT id, firstname, lastname, username, bot_name, age, gender, education, interest_in_movies, used_recommender_system"
				+ " FROM movierecsys_db.users"
				+ " WHERE users.id = " + user_id + " ;";
		
		return SQL;
	}
	
	public static String SQLselectMessageDetailAndContextByUser(int user_id, String context, int pagerank_cicle){
		String SQL = "SELECT *"
				+ " FROM movierecsys_db.chats"
				+ " WHERE chats.chat_id = " + user_id
				+ " AND chats.context = \"" + context + "\""
				+ " AND chats.pagerank_cicle = " + pagerank_cicle
				+ " ORDER BY ID DESC LIMIT 1;";
		
		return SQL;
	}
	
	public static String SQLselectPropertyRatingByUserAndProperty(int user_id, String property_type_uri, String property_uri, String last_change){
		String SQL = "SELECT user_id, property_type_uri, property_uri, rating, rated_at, last_change"
				+ " FROM movierecsys_db.ratings_properties"
				+ " WHERE ratings_properties.user_id = " + user_id
				+ " AND ratings_properties.property_type_uri = \"" + property_type_uri + "\""
				+ " AND ratings_properties.property_uri = \"" + property_uri + "\""
				+ " AND ratings_properties.last_change = \"" + last_change + "\""
				+ " ;";
		
		return SQL;
	}

	public static String SQLselectUser(int user_id) {
		String SQL = 	"SELECT id FROM users" +
						" WHERE `id` = " + user_id + ";";
		return SQL;
	}
	
	public static String SQLselectMovie(String uri) {
		String SQL = 	"SELECT uri FROM movies" +
						" WHERE `uri` = \"" + uri + "\";";
		return SQL;
	}
		

	
	public static String SQLselectMovieFromScoresByUserAndProperty(int user_id, String propertyTypeURI, String propertyURI) {
		String SQL = "SELECT movie_uri, score FROM scores_rec_movies" +
					" WHERE scores_rec_movies.user_id = " + user_id + 
					" AND scores_rec_movies.property_type_uri = \"" + propertyTypeURI + "\"" +
					" AND scores_rec_movies.property_uri = \"" + propertyURI + "\";";
		return SQL;
	}
		
	public static String SQLselectMovieAndScoreFromScoresByUserAndMovie(int user_id, String movieURI) {
		String SQL = "SELECT movie_uri, score FROM scores_rec_movies" +
					" WHERE scores_rec_movies.user_id = " + user_id + 
					" AND scores_rec_movies.property_type_uri = \"movie\"" +
					" AND scores_rec_movies.property_uri = \"" + movieURI + "\";";
		
		
//		String SQL = 	"SELECT scores_rec_movies.movie_uri, scores_rec_movies.score FROM scores_rec_movies" +
//						" INNER JOIN " + propertyTable + " ON scores_rec_movies.movie_uri = " + propertyTable + "." + columnMovieURI +
//						" WHERE scores_rec_movies.user_id = " + user_id + 
//						" AND scores_rec_movies.property_type_uri = \"" + propertyTypeURI + "\"" +
//						" AND " + propertyTable + "." + columnPropertyURI + " = \"" + propertyURI + "\";";
		
		return SQL;
	}
	
	public static String SQLselectPropertyValueAndScoreFromScoresRecMovies(int user_id, String movieURI, String propertyTypeURI){
		String SQL = "SELECT property_uri, score FROM scores_rec_movies" +
					" WHERE scores_rec_movies.user_id = " + user_id + 
					" AND scores_rec_movies.property_type_uri = \"" + propertyTypeURI + "\"" +
					" AND scores_rec_movies.movie_uri = \"" + movieURI + "\";";
		
		return SQL;
	}
	
	public static String SQLselectMoviesAndScoreFromScoresRecMovies(int user_id) {
		String SQL = 	"SELECT movie_uri, score FROM scores_rec_movies" +
						" WHERE scores_rec_movies.user_id = " + user_id + 
						" AND scores_rec_movies.property_type_uri = \"movie\";";
		return SQL;
	}
	
	public static String SQLselectMoviesMapAndScoreFromScoresRecMovies(int user_id, String propertyTypeURI, String propertyTable) {
		String SQL = 	"SELECT distinct property_uri as uri, score FROM scores_rec_movies "
						+ "WHERE scores_rec_movies.user_id = " + user_id + " AND scores_rec_movies.property_type_uri = \"" + propertyTypeURI + "\""
						+ " ORDER BY score DESC LIMIT 10;";
		return SQL;
	}
	
	public static String SQLselectBotConfigurationSetByUser(int user_id){
		String SQL = 	"SELECT distinct bot_name  FROM user_bot_configurations "
						+ "WHERE user_bot_configurations.user_id = " + user_id + ";";
		
		return SQL;
		
	}
	
	//TODO - DONE unisce i diversi insieme di propriet� considerando 
	//in unione quelle con score maggiore al tempo 0, quelle gradite, quelle dei film graditi e quelli dei film raccomandabili
	public static String SQLselectPropertyValueListMapFromPropertyType(int user_id, String propertyTypeURI, String propertyTable){
		String SQL = "(SELECT distinct s.uri AS uri, v.score AS score "
					+ "FROM " + propertyTable + " AS s "
					+ "INNER JOIN vertices_trailer_selection v ON s.uri = v.uri "
					+ "AND s.uri <> all"
						+ "(SELECT distinct property_uri AS uri FROM scores_user_properties "
						+ "WHERE scores_user_properties.user_id = " + user_id + " "
						+ "AND scores_user_properties.property_type_uri = \"" + propertyTypeURI + "\")"
					+ "ORDER BY score DESC LIMIT 50) "
				+ "UNION "
				+  "(SELECT distinct property_uri AS uri, score FROM scores_user_movies "
					+ "WHERE scores_user_movies.user_id = " + user_id + " AND scores_user_movies.property_type_uri = \"" + propertyTypeURI + "\" "
					+ "AND property_uri <> all"
						+ "(SELECT distinct property_uri AS uri FROM scores_user_properties "
						+ "WHERE scores_user_properties.user_id = " + user_id + " "
						+ "AND scores_user_properties.property_type_uri = \"" + propertyTypeURI + "\")"
					+ " ORDER BY score DESC LIMIT 15) "
				+ "UNION "
					+ "(SELECT distinct property_uri AS uri, score FROM scores_rec_movies "
					+ "WHERE scores_rec_movies.user_id = " + user_id + " AND scores_rec_movies.property_type_uri = \"" + propertyTypeURI + "\" "
					+ "AND property_uri <> all"
						+ "(SELECT distinct property_uri AS uri FROM scores_user_properties "
						+ "WHERE scores_user_properties.user_id = " + user_id + " "
						+ "AND scores_user_properties.property_type_uri = \"" + propertyTypeURI + "\")"
					+ " ORDER BY score DESC LIMIT 15) "
				+ "ORDER BY score DESC LIMIT 50;";
		
		return SQL;
	}
	
	public static String SQLselectPropertyValueListMapForReleaseYearAndRuntimeRange(int user_id, String propertyTypeURI, String propertyTable, String columnPropertyURI){
		String SQL = "(SELECT distinct s." + columnPropertyURI + " AS uri, v.score AS score "
					+ "FROM " + propertyTable + " AS s "
					+ "INNER JOIN vertices_trailer_selection v ON s.uri = v.uri "
					+ "ORDER BY score DESC LIMIT 30) "
				+ "UNION "
				+  "(SELECT distinct property_uri AS uri, score FROM scores_user_movies "
					+ "WHERE scores_user_movies.user_id = " + user_id + " AND scores_user_movies.property_type_uri = \"" + propertyTypeURI + "\""
					+ " ORDER BY score DESC LIMIT 10) "
				+ "UNION "
					+ "(SELECT distinct property_uri AS uri, score FROM scores_rec_movies "
					+ "WHERE scores_rec_movies.user_id = " + user_id + " AND scores_rec_movies.property_type_uri = \"" + propertyTypeURI + "\""
					+ " ORDER BY score DESC LIMIT 10) "
				+ "UNION "
					+ "(SELECT distinct property_uri AS uri, score FROM scores_user_properties "
					+ "WHERE scores_user_properties.user_id = " + user_id + " AND scores_user_properties.property_type_uri = \"" + propertyTypeURI + "\""
					+ " ORDER BY score DESC LIMIT 10) "
				+ "ORDER BY score DESC LIMIT 30;";
		
		return SQL;
	}

	public static String SQLselectDirectorFromDirectorsMovies(String movie_uri) {
		String SQL = 	"SELECT director_uri FROM directors_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectProducerFromProducersMovies(String movie_uri) {
		String SQL = 	"SELECT producer_uri FROM producers_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;	
	}
	
	public static String SQLselectWriterFromWritersMovies(String movie_uri) {
		String SQL = 	"SELECT writer_uri FROM writers_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectStarringFromStarringMovies(String movie_uri) {
		String SQL = 	"SELECT starring_uri FROM starring_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectMusicComposerFromMusicComposersMovies(String movie_uri) {
		String SQL = 	"SELECT music_composer_uri FROM music_composers_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectCinematographyFromCinematographersMovies(String movie_uri) {
		String SQL = 	"SELECT cinematography_uri FROM cinematographers_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectEditingFromEditingsMovies(String movie_uri) {
		String SQL = 	"SELECT editing_uri FROM editings_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectDistributorFromDistributorsMovies(String movie_uri) {
		String SQL = 	"SELECT distributor_uri FROM distributors_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	public static String SQLselectBasedOnFromBasedOnMovies(String movie_uri) {
		String SQL = 	"SELECT based_on_uri FROM based_on_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//title
	public static String SQLselectTitleFromMovies(String movie_uri) {
		String SQL = 	"SELECT title FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	releaseYear
	public static String SQLselectReleaseYearFromMovies(String movie_uri) {
		String SQL = 	"SELECT release_year FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;
	}
	
	//	referencePeriod
	public static String SQLselectReferencePeriodFromMovies(String movie_uri) {
		String SQL = 	"SELECT reference_period FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;
	}
		
	//	releaseDate
	public static String SQLselectReleaseDateFromMovies(String movie_uri) {
		String SQL = 	"SELECT release_date FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;
	}
	
	//	runtimeMinutes
	public static String SQLselectRuntimeMinutesFromMovies(String movie_uri) {
		String SQL = 	"SELECT runtime_minutes FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	runtimeRange
	public static String SQLselectRuntimeRangeFromMovies(String movie_uri) {
		String SQL = 	"SELECT runtime_range FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	runtimeUri
	public static String SQLselectRuntimeURIFromMovies(String movie_uri) {
		String SQL = 	"SELECT runtime_uri FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	plot
	public static String SQLselectPlotFromMovies(String movie_uri) {
		String SQL = 	"SELECT plot FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	language
	public static String SQLselectLanguageFromMovies(String movie_uri) {
		String SQL = 	"SELECT language FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	country
	public static String SQLselectCountryFromMovies(String movie_uri) {
		String SQL = 	"SELECT country FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	awards
	public static String SQLselectAwardsFromMovies(String movie_uri) {
		String SQL = 	"SELECT awards FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	poster
	public static String SQLselectPosterFromMovies(String movie_uri) {
		String SQL = 	"SELECT poster FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	trailer
	public static String SQLselectTrailerFromMovies(String movie_uri) {
		String SQL = 	"SELECT trailer FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	score
	public static String SQLselectScoreFromMovies(String movie_uri) {
		String SQL = 	"SELECT score FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	metascore
	public static String SQLselectMetascoreFromMovies(String movie_uri) {
		String SQL = 	"SELECT metascore FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	imdbRating
	public static String SQLselectImdbRatingFromMovies(String movie_uri) {
		String SQL = 	"SELECT imdb_rating FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	imdbId
	public static String SQLselectImdbIdFromMovies(String movie_uri) {
		String SQL = 	"SELECT imdb_id FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	//	imdbVotes
	public static String SQLselectImdbVotesFromMovies(String movie_uri) {
		String SQL = 	"SELECT imdb_votes FROM movies" +
						" WHERE `uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	

	public static String SQLselectCategoryFromCategoriesMovies(String movie_uri) {
		String SQL = 	"SELECT category_uri FROM categories_movies" +
						" WHERE `movie_uri` = \"" + movie_uri + "\";";
		return SQL;		
	}
	
	
	public static String SQLselectAcceptRecMovieToRatingByUser(int user_id){
		String SQL = 	"SELECT movie_uri FROM ratings_accept_rec_movies "
						+ "WHERE `user_id` = " + user_id + " AND rating = 3 "
						+ "ORDER BY rated_at DESC limit 1;";
		
		return SQL;
	}
	
	public static String SQLselectMovieToRatingByUser(int user_id, String movie_uri){
		String SQL = 	"SELECT movie_uri FROM ratings_movies" +
						" WHERE `user_id` = " + user_id + " AND `movie_uri` = \"" + movie_uri + "\";";
		return SQL;
	}
	
	public static String SQLselectPosRatingForUserFromRatingsMovies(int user_id) {
		String SQL = 	"SELECT movie_uri FROM ratings_movies" +
						" WHERE `user_id` = " + user_id + " AND rating = 1;";
		return SQL;
		
	}
	
	public static String SQLselectNegRatingForUserFromRatingsMovies(int user_id) {
		String SQL = 	"SELECT movie_uri FROM ratings_movies" +
						" WHERE `user_id` = " + user_id + " AND rating = 0;";
		return SQL;
		
	}
	
	public static String SQLselectPosRatingForUserFromRatingsMoviesByUser(int user_id) {
		String SQL = 	"SELECT movie_uri FROM ratings_movies" +
						" WHERE `user_id` = " + user_id + " AND rating = 1 AND last_change = 'user';";
		return SQL;
		
	}
	
	public static String SQLselectNegRatingForUserFromRatingsMoviesByUser(int user_id) {
		String SQL = 	"SELECT movie_uri FROM ratings_movies" +
						" WHERE `user_id` = " + user_id + " AND rating = 0 AND last_change = 'user';";
		return SQL;
		
	}
	
	//seleziona il filtro se presente per visualizzarlo e modificarlo dal profilo utente
	public static String SQLselectReleaseYearFilterFromUsersForPropertyRating(int user_id){
		String SQL = "SELECT release_year_filter FROM movierecsys_db.users "
					+ "WHERE id =  " + user_id + " "
					+ "AND release_year_filter <> 'no_release_year_filter';";
		
		return SQL;
	}
	
	//seleziona il filtro se presente per visualizzarlo e modificarlo dal profilo utente
	public static String SQLselectRuntimeRangeFilterFromUsersForPropertyRating(int user_id){
		String SQL = "SELECT runtime_range_filter FROM movierecsys_db.users "
					+ "WHERE id =  " + user_id + " "
					+ "AND runtime_range_filter <> 'no_runtime_range_filter';";
		
		return SQL;
	}

	public static String SQLselectPosNegRatingForUserFromRatingsProperties(int user_id) {
		String SQL = 	"SELECT property_uri, property_type_uri, rating FROM ratings_properties" +
						" WHERE `user_id` = " + user_id + " "
						+ "AND `last_change` = 'user' "
						+ "AND (ratings_properties.rating = 0 OR ratings_properties.rating = 1);";
		return SQL;		
	}
	
	public static String selectPosNegRatingFromRatingsPropertiesForPageRank(int user_id) {
		String SQL = 	"SELECT property_uri, property_type_uri, rating FROM ratings_properties" +
						" WHERE `user_id` = " + user_id + " "
						+ "AND (ratings_properties.rating = 0 OR ratings_properties.rating = 1);";
		return SQL;		
	}
	
	public static String selectNegRatingFromRatingsMoviesAndPropertiesForPageRank(int user_id) {
		String SQL = 	"(SELECT movie_uri as uri FROM ratings_movies "
						+ "WHERE `user_id` = " + user_id + " AND rating = 0) "
						+ "union "
						+ "(SELECT property_uri as uri FROM ratings_properties "
						+ "WHERE `user_id` = " + user_id + " "
						+ "AND ratings_properties.rating = 0);";
		return SQL;		
	}
	
	public static String SQLselectPosNegRatingForUserFromRatingsMovies(int user_id) {
		String SQL = 	"SELECT movie_uri, rating FROM movierecsys_db.ratings_movies" +
						" WHERE `user_id` = " + user_id + " "
						+ "AND `last_change` = 'user' "
						+ "AND (ratings_movies.rating = 0 OR ratings_movies.rating = 1);";
		return SQL;		
	}	

//	public static String SQLselectTestSetForUserFromMovies(int user_id) {
//		String SQL = 	"SELECT DISTINCT uri FROM movies" +
//						" WHERE `title` IS NOT NULL AND `poster` != \"N/A\" AND `release_year` > 1970 OR `release_year` Is NULL AND `uri` <> all (" + 
//											"SELECT movie_uri FROM ratings_movies " +											
//											//" WHERE `user_id` = " + user_id + ");";
//											" WHERE `user_id` = " + user_id + ")LIMIT 1000;"; //Limit 50;
//		return SQL;
//	}
	
	
	public static String SQLselectAllGenresFromGenresMoviesByMovie(String movie_uri){
		String SQL = 	"SELECT genre_name FROM genres_movies" +
						" WHERE movie_uri = \"" + movie_uri + "\";";
		
		return SQL;
	}
	
	//TODO - DONE la selezione è impostata su questa tabella in modo da aggiungere anche in film inseriti dall'utente e non presenti tra i trailer
	public static String SQLselectAllPropertyFromDbpediaMoviesSelection(String movie_uri){
		String SQL = 	"SELECT subject,predicate,object FROM mapping_dbpedia_movies_poster_selection" +
						" WHERE subject = \"" + movie_uri + "\";";
		
		return SQL;
	}
	
	//obsoleta
//	public static String SQLselectAllPropertyFromDbpediaMoviesSelection(){
//		String SQL = 	"SELECT subject,predicate,object FROM mapping_dbpedia_movies_trailer_selection;";
//		
//		return SQL;
//	}
	
	//seleziona il runtime_range_filter
	public static String SQLselectRuntimeRangeFilterFromUsers(int user_id) {
		String SQL = 	"SELECT runtime_range_filter "
						+ "FROM users "
						+ "WHERE `id` = " + user_id + ";";										
		return SQL;
	}
		
	//seleziona il release_year_filter
	public static String SQLselectReleaseYearFilterFromUsers(int user_id) {
		String SQL = 	"SELECT release_year_filter "
						+ "FROM users "
						+ "WHERE `id` = " + user_id + ";";										
		return SQL;
	}
	
	//TODO - DONE Seleziona tutti i film che hanno un trailer non valutati dall'utente
	public static String SQLselectTestSetForUserFromMovies(int user_id) {
		String SQL = 	"SELECT DISTINCT uri FROM movies" +
						" WHERE trailer IS NOT NULL AND poster <> \"N/A\" AND `uri` <> all (" +
						//" WHERE `poster` IS NOT NULL AND `uri` <> all (" +
											"SELECT movie_uri FROM ratings_movies" +	
											" WHERE `user_id` = " + user_id + ");";										
		return SQL;
	}
	
	//Select di tutti i film che hanno un trailer e uno specifico runtime_range_filter non valutati dall'utente
	public static String SQLselectTestSetForUserFromMoviesWithRuntimeRangeFilter(int user_id, String runtime_range_filter) {
		String SQL = 	"SELECT DISTINCT uri FROM movies"
						+ " WHERE trailer IS NOT NULL"
						+ " AND runtime_range = " + runtime_range_filter + ""
						+ " AND `uri` <> all (" +
											"SELECT movie_uri FROM ratings_movies" +	
											" WHERE `user_id` = " + user_id + ");";										
		return SQL;
	}
	
	//Select di tutti i film che hanno un trailer e uno specifico release_year_filter, non valutati dall'utente
	public static String SQLselectTestSetForUserFromMoviesWithReleaseYearFilter(int user_id, String release_year_filter) {
		String SQL = 	"SELECT DISTINCT uri FROM movies"
						+ " WHERE trailer IS NOT NULL"
						+ " AND reference_period = \"" + release_year_filter + "\""
						+ " AND `uri` <> all (" +
											"SELECT movie_uri FROM ratings_movies" +	
											" WHERE `user_id` = " + user_id + ");";										
		return SQL;
	}
	
	//Select di tutti i film che hanno un trailer e uno specifico release_year_filter e runtime_range_filter, non valutati dall'utente
	public static String SQLselectTestSetForUserFromMoviesWithAllFilter(int user_id, String release_year_filter, String runtime_range_filter) {
		String SQL = 	"SELECT DISTINCT uri FROM movies"
						+ " WHERE trailer IS NOT NULL "
						+ " AND reference_period = \"" + release_year_filter + "\""
						+ " AND runtime_range = " + runtime_range_filter + ""
						+ " AND `uri` <> all (" +
											"SELECT movie_uri FROM ratings_movies" +	
											" WHERE `user_id` = " + user_id + ");";										
		return SQL;
	}
	
	
	//vecchia query creazione grafo
	//Selezione film fatta sullo score, sulla data e sul poster
//	public static String SQLselectTestSetForUserFromMovies(int user_id) {
//		String SQL = 	"SELECT DISTINCT uri FROM movies" +
//						//" WHERE `poster` != \"N/A\" AND `uri` <> all (" + 
//						" WHERE `poster` != \"N/A\" AND `release_year` > 2010 AND `uri` <> all (" + 
//											"SELECT movie_uri FROM ratings_movies " +											
//											" WHERE `user_id` = " + user_id + ") " +
//											//" WHERE `user_id` = " + user_id + ");";
//											" ORDER BY score DESC LIMIT 2000;";
//											
//		return SQL;
//	}
	
//	public static String SQLselectTestSetAndPosRatingForUser(int user_id){
//	String SQL = 	"SELECT DISTINCT uri FROM movies" +
//					" WHERE `title` IS NOT NULL AND `release_year` > 1970 OR `release_year` Is NULL AND `uri` <> all (" + 
//								"SELECT movie_uri FROM ratings_movies " +									
//								//" WHERE `user_id` = " + user_id + " AND rating = 0);";
//								" WHERE `user_id` = " + user_id + " AND rating = 0)LIMIT 10000;"; //Limit 50;
//	return SQL;
//}
	
	public static String SQLselectNameFromUriInVertexPosterSelection(String uri){
		String SQL = "SELECT uri, name, score "
					+ "FROM movierecsys_db.vertices_poster_selection "
					+ "WHERE uri = \"" + uri + "\";";

		return SQL;
	}
	public static String SQLselectUriAndNameFromVertexPosterSelection(){
		String SQL = "SELECT uri, name "
					+ "FROM movierecsys_db.vertices_poster_selection "
					+ "WHERE name IS NOT NULL;";

		return SQL;
	}
	
	public static String SQLselectUriFromVertexTrailerSelection(){
		String SQL = "(SELECT uri, name FROM vertices_trailer_selection WHERE name IS NOT null) "
						+ "UNION "
						+ "(SELECT uri, title as name FROM movies WHERE title IS NOT null) "
						+ "UNION "
						+ "(SELECT uri, name FROM starring WHERE name IS NOT null);";
		
		return SQL;
	}
	
	public static String SQLsearchUriAndNameFromVertexTrailerSelectionByText(String text){
		String SQL = "SELECT * FROM "
						+ "(SELECT uri, name, score FROM vertices_trailer_selection WHERE name IS NOT null "
						+ "UNION "
						+ "SELECT uri, title as name, score FROM movies WHERE title IS NOT null AND poster <> \"N/A\" ) "
						+ "AS u "
						+ "WHERE u.name LIKE \"%" + text + "%\" ORDER BY score DESC LIMIT 10;";
		
		return SQL;
	}
	
	public static String SQLselectPropertyTypeFromPropertyValue(String propertyValue){
		String SQL = "SELECT distinct predicate "
				//+ "FROM movierecsys_db.mapping_dbpedia_movies_trailer_selection "
				+ "FROM movierecsys_db.mapping_dbpedia_movies_poster_selection "
				+ "WHERE object = \"" + propertyValue + "\";";
		
		return SQL;
	}
	
	public static String SQLselectAllPropertiesFromMoviesBymovie(String movie_uri){
		String SQL = 	"SELECT "
						+ " m.release_year,"
						+ " dm.director_uri,"
						+ " pm.producer_uri,"
						+ " wm.writer_uri,"
						+ " sm.starring_uri,"
						+ " mcm.music_composer_uri,"
						+ " cm.cinematography_uri,"
						+ " em.editing_uri,"
						+ " dim.distributor_uri,"
						+ " bm.based_on_uri,"
						+ " cam.category_uri"
						+ " FROM movies m"
						+ " LEFT OUTER JOIN directors_movies dm ON m.uri = dm.movie_uri"
						+ " LEFT OUTER JOIN producers_movies pm ON m.uri = pm.movie_uri"
						+ " LEFT OUTER JOIN writers_movies wm ON m.uri = wm.movie_uri"
						+ " LEFT OUTER JOIN starring_movies sm ON m.uri = sm.movie_uri"
						+ " LEFT OUTER JOIN music_composers_movies mcm ON m.uri = mcm.movie_uri"
						+ " LEFT OUTER JOIN cinematographers_movies cm ON m.uri = cm.movie_uri"
						+ " LEFT OUTER JOIN editings_movies em ON m.uri = em.movie_uri"
						+ " LEFT OUTER JOIN distributors_movies dim ON m.uri = dim.movie_uri"
						+ " LEFT OUTER JOIN based_on_movies bm ON m.uri = bm.movie_uri"
						+ " LEFT OUTER JOIN categories_movies cam ON m.uri = cam.movie_uri"
						+ " WHERE m.uri = \"" + movie_uri + "\";";
		return SQL;
	}
	
	
//	public static String SQLselectTestSetForUserFromMovies(int user_id) {
//	String SQL = 	"SELECT DISTINCT uri FROM movies" +
//					" WHERE `uri` = 'http://dbpedia.org/resource/Barry_Lyndon' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/The_Dark_Knight_(film)' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/Jumper_(film)' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/The_Dark_Knight_Rises' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/Eyes_Wide_Shut' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/Panic_Room' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/The_Prestige_(film)' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/Iron_Man_3' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/Batman_Begins' "
//					+ "OR `uri` = 'http://dbpedia.org/resource/The_Incredible_Hulk_(film)' "
//					+ "AND `uri` <> all (" + 
//										"SELECT movie_uri FROM ratings_movies " +
//										" WHERE `user_id` = " + user_id + ")LIMIT 10;"; //Limit 50;
//										//" WHERE `user_id` = " + user_id + ");";
//	return SQL;
//}




	
}
