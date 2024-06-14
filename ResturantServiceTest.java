import com.resturant.project.Resturant;
import com.resturant.project.ResturantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ResturantServiceTest {

    @Mock
    private ResturantRepository resturantRepository;

    @Test(expected=ParseException.class)
    public void Is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){

        SimpleDateFormat dtDate=new SimpleDateFormat("dd/MM/yyyy");
        Date targetTime = dtDate.parse("09:00:00");
        verify(resturantRepository).isRestaurantOpen(targetTime);
        when(resturantRepository.isRestaurantOpen(targetTime)).thenReturn(true);
        boolean actualResult = resturantRepository.isRestaurantOpen(targetTime);
        Assertions.assertFalse(actualResult);


    }

    @Test(expected=ParseException.class)
    public void Is_restarunt_open_should_return_true_if_time_is_between_opening_and_closing_time(){
        SimpleDateFormat dtDate=new SimpleDateFormat("dd/MM/yyyy");

        LocalDate targetTime = LocalDate.parse("09:00:00");
        verify(resturantRepository).getAllResturants();
        List<Resturant> resturants=resturantRepository.getAllResturants();
        for(Resturant resturant : resturants) {
            LocalDate resturantStartTime=new java.sql.Date(resturant.getStartTime().getTime()).toLocalDate();
            LocalDate resturantClosedTime=new java.sql.Date(resturant.getCloseTime().getTime()).toLocalDate();
            Assertions.assertTrue(!targetTime.isBefore(resturantStartTime) && !targetTime.isAfter(resturantClosedTime));
        }
        
    }

    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception(){

        String resturanName="KFC";
        Resturant resturant=new Resturant();
        resturant.setName(resturanName);
        verify(resturantRepository).findByResturantByName(resturanName);
        when(resturantRepository.findByResturantByName(resturanName)).thenReturn(resturant);
        Resturant resturant1=resturantRepository.findByResturantByName(resturanName);
        Assertions.assertEquals(resturanName, resturant1.getName());

    }
}
