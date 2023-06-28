<?php 
// get current link  
$url = 'http://' . $_SERVER['HTTP_HOST'] . $_SERVER['REQUEST_URI'];  

$title = get_title($url);

if(isset($_POST['submit'])){
    $to = "gian.alix@gmail.com"; // this is your Email address
    $from = $_POST['email']; // this is the sender's Email address
    $user = $_POST['usr'];
    $subject = "Re:" . $title;
    $subject2 = "Copy of your form submission";
    $message = "Re: " . $title . "\n\n" . $user . " wrote the following:" . "\n\n" . $_POST['comment'];
    $message2 = "Here is a copy of your message " . $first_name . "\n\n" . $_POST['message'];

    $headers = "From:" . $from;
    $headers2 = "From:" . $to;
    mail($to,$subject,$message,$headers);
    //mail($from,$subject2,$message2,$headers2); // sends a copy of the message to the sender
    // echo "Message sent. Thank you.";
    header('Location: success-page.html');
    // You can also use header('Location: thank_you.php'); to redirect to another page.
    // You cannot use header and echo together. It's one or the other.
    }

function get_title($url) {
        $title = '';
        $dom = new DOMDocument();

        if($dom->loadHTMLFile($url)) {
            $list = $dom->getElementsByTagName("title");
            if ($list->length > 0) {
                $title = $list->item(0)->textContent;
            }
        }
        return $title;
    }



?>