package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelInMemoryService implements HotelService {

    private List<HotelModel> listHotel;

    // Constructor
    public HotelInMemoryService() {
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel) {
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList() {
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel) {
        HotelModel hotel = null;

        for (int i = 0; i < listHotel.size() ; i++ ) {
            if (listHotel.get(i).getIdHotel().equals(idHotel)) {
                hotel = listHotel.get(i);
            }
        }

        return hotel;
    }

    //Latihan
    @Override
    public void updateNomorTelepon(HotelModel hotel, String nomorTelepon) {
        hotel.setNoTelepon(nomorTelepon);
    }


    @Override
    public void deleteHotel(HotelModel hotel) {
        listHotel.remove(hotel);
    }

}
