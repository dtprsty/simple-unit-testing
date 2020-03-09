package id.dtprsty.simpleunittesting

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class UtilsTest {

    @Test
    fun toSimpleString() {
        val dateFormat: DateFormat = SimpleDateFormat("MM/dd/yyyy")
        var date: Date? = null
        try{
            date = dateFormat.parse("02/29/2020")
        }catch (e: ParseException){
            e.printStackTrace()
        }
        assertEquals("Sat, 29 Feb 2020", Utils().toSimpleString(date))
    }
}