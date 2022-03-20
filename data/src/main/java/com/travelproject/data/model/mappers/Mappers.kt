package com.travelproject.data.model.mappers

import com.travelproject.data.model.dto.*
import com.travelproject.domain.model.TravelPreview
import com.travelproject.domain.model.travel.*

fun TravelPreviewDto.toTravelPreview(): TravelPreview = TravelPreview(
    id = travelId,
    image = image,
    country = country
)

fun ImageDto.toTravelImage(): TravelImage = TravelImage(
    imageId = imageId, imageName = imageName
)

fun LocationGeneralDto.toLocationGeneral(): LocationGeneral = LocationGeneral(
    dayId = dayId,
    description = description,
    locationId = locationId,
    title = title
)

fun LocationDto.toLocation(): Location =
    Location(location = location.toLocationGeneral(), locationImages.map { imageDto -> imageDto.toTravelImage() })

fun DayGeneralDto.toDayGeneral(): DayGeneral = DayGeneral(dayId = dayId, description = description, order = order, title = title, travelId = travelId)

fun DayDto.toDay(): Day = Day(
    dayGeneral = dayGeneral.toDayGeneral(),
    dayImages = dayImages.map { imageDto -> imageDto.toTravelImage() },
    locations = locations.map { locationDto -> locationDto.toLocation() })

fun GeneralTravelDto.toGeneralTravel(): GeneralTravel = GeneralTravel(
    country = country,
    daysAmount = daysAmount,
    description = description,
    previewImage = previewImage,
    title = title,
    travelId = travelId,
    userEmail = userEmail
)

fun TravelDto.toTravel(): Travel = Travel(
    days = days.map { dayDto -> dayDto.toDay() },
    generalTravelImages = generalTravelImages.map { imageDto -> imageDto.toTravelImage() },
    generalTravel = generalTravelDto.toGeneralTravel()
)