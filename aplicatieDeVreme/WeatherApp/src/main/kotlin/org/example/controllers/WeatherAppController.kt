package org.example.controllers

import org.example.interfaces.LocationSearchInterface
import org.example.interfaces.WeatherForecastInterface
import org.example.pojo.WeatherForecastData
import org.example.services.TimeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
@Controller
class WeatherAppController {
    @Autowired
    private lateinit var locationSearchService: LocationSearchInterface

    @Autowired
    private lateinit var weatherForecastService: WeatherForecastInterface

    @RequestMapping("/getforecast/{location}", method = [RequestMethod.GET])
    @ResponseBody

    fun getForecast(@PathVariable location: String): String {
        val locationData = try {
            locationSearchService.getLocationData(location)
        } catch (e: IllegalArgumentException) {
            return "Nu s-au putut gasi date meteo pentru cuvintele cheie \"$location\"!"
        }
        val rawForecastData: WeatherForecastData =
        weatherForecastService.getForecastData(locationData)
        // fiind obiect POJO, funcţia toString() este suprascrisă pentru o afişare mai prietenoasă
        return rawForecastData.toString()
    }
}