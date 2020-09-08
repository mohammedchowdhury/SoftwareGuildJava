package com.mohammedchowdhury.bullsandcows.dao;
import com.mohammedchowdhury.bullsandcows.dto.Round;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mohammedchowdhury
 */
@Repository
public class RoundDaoImpl implements RoundDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Round addRound(Round newRound) {
        
        Round round = newRound; 
        
        final String sql = "INSERT INTO Round(Answer,Result,TimeOfGuess,GameID) "
                         + "VALUES(?,?,?,?);";
        try{
        jdbcTemplate.update(sql, newRound.getAnswer(), newRound.getResult(), newRound.getTimeOfGuess(), newRound.getGameID());
        }catch(Exception ex){
            return null; 
        }
        int newId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        newRound.setRoundID(newId);
        
        return newRound;
    }

    @Override
    public List<Round> getRoundForGameSortedByTime(int gameID) {
         List<Round> listOfRounds = null; 
        final String sql = "SELECT * FROM Round "
                + " WHERE GameID = ? "
                + " ORDER BY TimeOfGuess ;";
        try{
        listOfRounds = jdbcTemplate.query(sql, new RoundMapper(), gameID);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null; 
        }
        return listOfRounds;
    }
    
    @Override
    public void deleteRoundById(int roundID){
        final String sql = "SELECT * "
                         + "FROM Round "
                         + "WHERE RoundID = ?";
        jdbcTemplate.update(sql,roundID); 
    }
    
    

    public static final class RoundMapper implements RowMapper<Round> {
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round(rs.getInt("RoundID"), rs.getString("Answer"), rs.getString("Result"), rs.getTimestamp("TimeOfGuess").toLocalDateTime(), rs.getInt("GameID"));
            return round;
        }
    }
}
