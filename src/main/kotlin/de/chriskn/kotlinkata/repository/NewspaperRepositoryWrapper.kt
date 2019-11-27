package de.chriskn.kotlinkata.repository

import de.chriskn.kotlinkata.domain.Book
import java.util.*

class NewspaperRepositoryWrapper (legacyRepo : ILegacyBookingRepository) : ILegacyBookingRepository by legacyRepo {

}