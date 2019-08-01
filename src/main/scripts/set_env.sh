CLIENT_ID=811ch5okcma0dj
CLIENT_SECRET=P46yxdkUKCVAP7Xh

function getAccessToken {
	cmd="curl -X GET https://www.linkedin.com/oauth/v2/accessToken?grant_type=client_credentials&client_id=$CLIENT_ID&client_secret=$CLIENT_SECRET"
	echo $cmd
	eval $cmd
}
