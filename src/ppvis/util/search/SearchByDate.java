package ppvis.util.search;

import ppvis.util.model.Constants;
import ppvis.util.model.Player;
import ppvis.util.model.PlayerDTO;

import java.text.ParseException;
import java.util.Date;

public class SearchByDate implements SearchBy {
    @Override
    public boolean compare(Player player, Object object) throws ParseException {
        Date dateFrom = Constants.sdf.parse("1900-12-31");
        Date dateTo = Constants.sdf.parse("2000-12-31");
        PlayerDTO playerDTO = (PlayerDTO) object;
        if (playerDTO.getDateOfBirth().before(dateFrom) || playerDTO.getDateOfBirth().after(dateTo))
            return true;
        String playerDTOdate = Constants.sdf.format(playerDTO.getDateOfBirth());
        return playerDTOdate.equalsIgnoreCase(player.getDateOfBirthBeautiful());
    }
}
