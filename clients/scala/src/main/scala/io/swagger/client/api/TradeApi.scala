/**
 * BitMEX API
 * ## REST API for the BitMEX Trading Platform  [View Changelog](/app/apiChangelog)    #### Getting Started   ##### Fetching Data  All REST endpoints are documented below. You can try out any query right from this interface.  Most table queries accept `count`, `start`, and `reverse` params. Set `reverse=true` to get rows newest-first.  Additional documentation regarding filters, timestamps, and authentication is available in [the main API documentation](https://www.bitmex.com/app/restAPI).  *All* table data is available via the [Websocket](/app/wsAPI). We highly recommend using the socket if you want to have the quickest possible data without being subject to ratelimits.  ##### Return Types  By default, all data is returned as JSON. Send `?_format=csv` to get CSV data or `?_format=xml` to get XML data.  ##### Trade Data Queries  *This is only a small subset of what is available, to get you started.*  Fill in the parameters and click the `Try it out!` button to try any of these queries.  * [Pricing Data](#!/Quote/Quote_get)  * [Trade Data](#!/Trade/Trade_get)  * [OrderBook Data](#!/OrderBook/OrderBook_getL2)  * [Settlement Data](#!/Settlement/Settlement_get)  * [Exchange Statistics](#!/Stats/Stats_history)  Every function of the BitMEX.com platform is exposed here and documented. Many more functions are available.  ##### Swagger Specification  [⇩ Download Swagger JSON](swagger.json)    ## All API Endpoints  Click to expand a section. 
 *
 * OpenAPI spec version: 1.2.0
 * Contact: support@bitmex.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api

import java.text.SimpleDateFormat

import java.util.Date
import io.swagger.client.model.Error
import io.swagger.client.model.Number
import io.swagger.client.model.Trade
import io.swagger.client.model.TradeBin
import io.swagger.client.{ApiInvoker, ApiException}

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

import com.wordnik.swagger.client._
import scala.concurrent.Future
import collection.mutable

import java.net.URI

import com.wordnik.swagger.client.ClientResponseReaders.Json4sFormatsReader._
import com.wordnik.swagger.client.RequestWriters.Json4sFormatsWriter._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

class TradeApi(
  val defBasePath: String = "https://localhost/api/v1",
  defApiInvoker: ApiInvoker = ApiInvoker
) {

  implicit val formats = new org.json4s.DefaultFormats {
    override def dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+0000")
  }
  implicit val stringReader = ClientResponseReaders.StringReader
  implicit val unitReader = ClientResponseReaders.UnitReader
  implicit val jvalueReader = ClientResponseReaders.JValueReader
  implicit val jsonReader = JsonFormatsReader
  implicit val stringWriter = RequestWriters.StringWriter
  implicit val jsonWriter = JsonFormatsWriter

  var basePath: String = defBasePath
  var apiInvoker: ApiInvoker = defApiInvoker

  def addHeader(key: String, value: String): mutable.HashMap[String, String] = {
    apiInvoker.defaultHeaders += key -> value
  }

  val config = SwaggerConfig.forUrl(new URI(defBasePath))
  val client = new RestClient(config)
  val helper = new TradeApiAsyncHelper(client, config)

  /**
   * Get Trades.
   * Please note that indices (symbols starting with &#x60;.&#x60;) post trades at intervals to the trade feed. These have a &#x60;size&#x60; of 0 and are used only to indicate a changing price.  See [the FIX Spec](http://www.onixs.biz/fix-dictionary/5.0.SP2/msgType_AE_6569.html) for explanations of these fields.
   * @param symbol Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. &#x60;XBU:monthly&#x60;. Timeframes are &#x60;daily&#x60;, &#x60;weekly&#x60;, &#x60;monthly&#x60;, &#x60;quarterly&#x60;, and &#x60;biquarterly&#x60;. (optional)
   * @param filter Generic table filter. Send JSON key/value pairs, such as &#x60;{\&quot;key\&quot;: \&quot;value\&quot;}&#x60;. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#timestamp-filters) for more details. (optional)
   * @param columns Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect. (optional)
   * @param count Number of results to fetch. (optional, default to 100)
   * @param start Starting point for results. (optional, default to 0)
   * @param reverse If true, will sort results newest first. (optional, default to false)
   * @param startTime Starting date filter for results. (optional)
   * @param endTime Ending date filter for results. (optional)
   * @return List[Trade]
   */
  def tradeGet(symbol: Option[String] = None, filter: Option[String] = None, columns: Option[String] = None, count: Option[Number] /* = 100*/, start: Option[Number] /* = 0*/, reverse: Option[Boolean] /* = false*/, startTime: Option[Date] = None, endTime: Option[Date] = None): Option[List[Trade]] = {
    val await = Try(Await.result(tradeGetAsync(symbol, filter, columns, count, start, reverse, startTime, endTime), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Get Trades. asynchronously
   * Please note that indices (symbols starting with &#x60;.&#x60;) post trades at intervals to the trade feed. These have a &#x60;size&#x60; of 0 and are used only to indicate a changing price.  See [the FIX Spec](http://www.onixs.biz/fix-dictionary/5.0.SP2/msgType_AE_6569.html) for explanations of these fields.
   * @param symbol Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. &#x60;XBU:monthly&#x60;. Timeframes are &#x60;daily&#x60;, &#x60;weekly&#x60;, &#x60;monthly&#x60;, &#x60;quarterly&#x60;, and &#x60;biquarterly&#x60;. (optional)
   * @param filter Generic table filter. Send JSON key/value pairs, such as &#x60;{\&quot;key\&quot;: \&quot;value\&quot;}&#x60;. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#timestamp-filters) for more details. (optional)
   * @param columns Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect. (optional)
   * @param count Number of results to fetch. (optional, default to 100)
   * @param start Starting point for results. (optional, default to 0)
   * @param reverse If true, will sort results newest first. (optional, default to false)
   * @param startTime Starting date filter for results. (optional)
   * @param endTime Ending date filter for results. (optional)
   * @return Future(List[Trade])
  */
  def tradeGetAsync(symbol: Option[String] = None, filter: Option[String] = None, columns: Option[String] = None, count: Option[Number] /* = 100*/, start: Option[Number] /* = 0*/, reverse: Option[Boolean] /* = false*/, startTime: Option[Date] = None, endTime: Option[Date] = None): Future[List[Trade]] = {
      helper.tradeGet(symbol, filter, columns, count, start, reverse, startTime, endTime)
  }

  /**
   * Get previous trades in time buckets.
   * 
   * @param binSize Time interval to bucket by. Available options: [1m,5m,1h,1d]. (optional, default to 1m)
   * @param partial If true, will send in-progress (incomplete) bins for the current time period. (optional, default to false)
   * @param symbol Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. &#x60;XBU:monthly&#x60;. Timeframes are &#x60;daily&#x60;, &#x60;weekly&#x60;, &#x60;monthly&#x60;, &#x60;quarterly&#x60;, and &#x60;biquarterly&#x60;. (optional)
   * @param filter Generic table filter. Send JSON key/value pairs, such as &#x60;{\&quot;key\&quot;: \&quot;value\&quot;}&#x60;. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#timestamp-filters) for more details. (optional)
   * @param columns Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect. (optional)
   * @param count Number of results to fetch. (optional, default to 100)
   * @param start Starting point for results. (optional, default to 0)
   * @param reverse If true, will sort results newest first. (optional, default to false)
   * @param startTime Starting date filter for results. (optional)
   * @param endTime Ending date filter for results. (optional)
   * @return List[TradeBin]
   */
  def tradeGetBucketed(binSize: Option[String] /* = 1m*/, partial: Option[Boolean] /* = false*/, symbol: Option[String] = None, filter: Option[String] = None, columns: Option[String] = None, count: Option[Number] /* = 100*/, start: Option[Number] /* = 0*/, reverse: Option[Boolean] /* = false*/, startTime: Option[Date] = None, endTime: Option[Date] = None): Option[List[TradeBin]] = {
    val await = Try(Await.result(tradeGetBucketedAsync(binSize, partial, symbol, filter, columns, count, start, reverse, startTime, endTime), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Get previous trades in time buckets. asynchronously
   * 
   * @param binSize Time interval to bucket by. Available options: [1m,5m,1h,1d]. (optional, default to 1m)
   * @param partial If true, will send in-progress (incomplete) bins for the current time period. (optional, default to false)
   * @param symbol Instrument symbol. Send a bare series (e.g. XBU) to get data for the nearest expiring contract in that series.  You can also send a timeframe, e.g. &#x60;XBU:monthly&#x60;. Timeframes are &#x60;daily&#x60;, &#x60;weekly&#x60;, &#x60;monthly&#x60;, &#x60;quarterly&#x60;, and &#x60;biquarterly&#x60;. (optional)
   * @param filter Generic table filter. Send JSON key/value pairs, such as &#x60;{\&quot;key\&quot;: \&quot;value\&quot;}&#x60;. You can key on individual fields, and do more advanced querying on timestamps. See the [Timestamp Docs](https://www.bitmex.com/app/restAPI#timestamp-filters) for more details. (optional)
   * @param columns Array of column names to fetch. If omitted, will return all columns.  Note that this method will always return item keys, even when not specified, so you may receive more columns that you expect. (optional)
   * @param count Number of results to fetch. (optional, default to 100)
   * @param start Starting point for results. (optional, default to 0)
   * @param reverse If true, will sort results newest first. (optional, default to false)
   * @param startTime Starting date filter for results. (optional)
   * @param endTime Ending date filter for results. (optional)
   * @return Future(List[TradeBin])
  */
  def tradeGetBucketedAsync(binSize: Option[String] /* = 1m*/, partial: Option[Boolean] /* = false*/, symbol: Option[String] = None, filter: Option[String] = None, columns: Option[String] = None, count: Option[Number] /* = 100*/, start: Option[Number] /* = 0*/, reverse: Option[Boolean] /* = false*/, startTime: Option[Date] = None, endTime: Option[Date] = None): Future[List[TradeBin]] = {
      helper.tradeGetBucketed(binSize, partial, symbol, filter, columns, count, start, reverse, startTime, endTime)
  }

}

class TradeApiAsyncHelper(client: TransportClient, config: SwaggerConfig) extends ApiClient(client, config) {

  def tradeGet(symbol: Option[String] = None,
    filter: Option[String] = None,
    columns: Option[String] = None,
    count: Option[Number] = Some(100),
    start: Option[Number] = Some(0),
    reverse: Option[Boolean] = Some(false),
    startTime: Option[Date] = None,
    endTime: Option[Date] = None
    )(implicit reader: ClientResponseReader[List[Trade]]): Future[List[Trade]] = {
    // create path and map variables
    val path = (addFmt("/trade"))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    symbol match {
      case Some(param) => queryParams += "symbol" -> param.toString
      case _ => queryParams
    }
    filter match {
      case Some(param) => queryParams += "filter" -> param.toString
      case _ => queryParams
    }
    columns match {
      case Some(param) => queryParams += "columns" -> param.toString
      case _ => queryParams
    }
    count match {
      case Some(param) => queryParams += "count" -> param.toString
      case _ => queryParams
    }
    start match {
      case Some(param) => queryParams += "start" -> param.toString
      case _ => queryParams
    }
    reverse match {
      case Some(param) => queryParams += "reverse" -> param.toString
      case _ => queryParams
    }
    startTime match {
      case Some(param) => queryParams += "startTime" -> param.toString
      case _ => queryParams
    }
    endTime match {
      case Some(param) => queryParams += "endTime" -> param.toString
      case _ => queryParams
    }

    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  def tradeGetBucketed(binSize: Option[String] = Some(1m),
    partial: Option[Boolean] = Some(false),
    symbol: Option[String] = None,
    filter: Option[String] = None,
    columns: Option[String] = None,
    count: Option[Number] = Some(100),
    start: Option[Number] = Some(0),
    reverse: Option[Boolean] = Some(false),
    startTime: Option[Date] = None,
    endTime: Option[Date] = None
    )(implicit reader: ClientResponseReader[List[TradeBin]]): Future[List[TradeBin]] = {
    // create path and map variables
    val path = (addFmt("/trade/bucketed"))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    binSize match {
      case Some(param) => queryParams += "binSize" -> param.toString
      case _ => queryParams
    }
    partial match {
      case Some(param) => queryParams += "partial" -> param.toString
      case _ => queryParams
    }
    symbol match {
      case Some(param) => queryParams += "symbol" -> param.toString
      case _ => queryParams
    }
    filter match {
      case Some(param) => queryParams += "filter" -> param.toString
      case _ => queryParams
    }
    columns match {
      case Some(param) => queryParams += "columns" -> param.toString
      case _ => queryParams
    }
    count match {
      case Some(param) => queryParams += "count" -> param.toString
      case _ => queryParams
    }
    start match {
      case Some(param) => queryParams += "start" -> param.toString
      case _ => queryParams
    }
    reverse match {
      case Some(param) => queryParams += "reverse" -> param.toString
      case _ => queryParams
    }
    startTime match {
      case Some(param) => queryParams += "startTime" -> param.toString
      case _ => queryParams
    }
    endTime match {
      case Some(param) => queryParams += "endTime" -> param.toString
      case _ => queryParams
    }

    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }


}
