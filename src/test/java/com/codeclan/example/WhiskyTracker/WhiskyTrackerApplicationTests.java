package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByYear(1991);
		assertEquals(1991, foundWhisky.get(0).getYear());
	}

	@Test
	public void canFindWhiskyByRegion(){
		List<Distillery> foundDistillery = distilleryRepository.findDistilleryByRegion("Speyside");
		assertEquals("Speyside", foundDistillery.get(0).getRegion());
	}

	@Test
	public void canFindWhiskyByDistilleryAndByAge(){
		List<Whisky> foundWhisky = whiskyRepository.findWhiskyByDistilleryIdAndAge(3L, 25);
		assertEquals("The Macallan Anniversary Malt", foundWhisky.get(0).getName());

	}

}
