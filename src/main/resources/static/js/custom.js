$(function(){
 
 initializeDatepicker()
 $(".se-pre-con").fadeOut("slow");

 $('.hrms-emp-table-header:first-child').addClass('hidden');
    var count = 0;
    localStorage.setItem('hrms-selected', 0);
 
    
    $('.employee-menu').click(function(){
        $('.loan-sub-menu').addClass('hidden');
        $('.leave-sub-menu').addClass('hidden');
        if($('.employee-sub-menu').hasClass('hidden')){
         $('.employee-sub-menu').removeClass('hidden');
         //SHOW THE LIST
         var this_text =$(this).find('.hrms-menu-navigate_icon').text();
            //$(this).find('.hrms-menu-navigate_icon').text() = 'expand_more';
        }else{
            $('.employee-sub-menu').addClass('hidden');
            //HIDE THE LIST
            // $(this).find('.hrms-menu-navigate_icon').html() = 'navigate_before';
        }
    })

    
    $('.leave-menu').click(function () {
        $('.loan-sub-menu').addClass('hidden');
        $('.employee-sub-menu').addClass('hidden');

        if ($('.leave-sub-menu').hasClass('hidden')) {

            $('.leave-sub-menu').removeClass('hidden');

        } else {
            $('.leave-sub-menu').addClass('hidden');
        }
    })
    
    $('.loan-menu').click(function () {
        $('.employee-sub-menu').addClass('hidden');
        $('.leave-sub-menu').addClass('hidden');

        if ($('.loan-sub-menu').hasClass('hidden')) {

            $('.loan-sub-menu').removeClass('hidden');
        } else {
            $('.loan-sub-menu').addClass('hidden');
        }
    })

    $('.dashboard-menu, .profile-menu').click(function(){
        $('.employee-sub-menu').addClass('hidden');
        $('.leave-sub-menu').addClass('hidden');
        $('.loan-sub-menu').addClass('hidden');
    });
    
   $(document).on('click', '.mdl-checkbox', function (event) {
        event.stopPropagation();
        event.stopImmediatePropagation();
        var $checkboxes = $('.hrms-tbl-tr');
        $checkboxes.change(function () {
            var countCheckedCheckboxes = $checkboxes.filter('.is-selected').length;
            if (countCheckedCheckboxes >= 2){	
                $('.create_person').addClass('hidden');
            }else{
                $('.create_person').removeClass('hidden');
           }
        });    
   });      
    
   $('.next_to_contract').click(function () {
        $('.contract_details').trigger('click');
        console.log("Go to contract tab");
    });
   
   
    $('.next_to_job').click(function () {
        // $('.personal_details').removeClass('is-active');
        // $('.job_details').addClass('is-active');

        // $('.contract_details').removeClass('is-active');

        //trigger on click to a button

        $('.job_details').trigger('click');
    });

    $('.back_to_personal_info').click(function () {

        // $('.personal_details').addClass('is-active');
        // $('.job_details').removeClass('is-active');

        // $('.contract_details').removeClass('is-active');

        $('.personal_details').trigger('click');

    });
    $('.back_to_contract').click(function () {

        // $('.personal_details').removeClass('is-active');
        // $('.job_details').removeClass('is-active');

        // $('.contract_details').addClass('is-active');

        $('.contract_details').trigger('click');
    });
    
    $(".hrms-modal-close").click(function(){
    	
        $(".hrms-modal").addClass("hidden");
        
    });
    
    $(".new-info-btn-education").click(function(){
    	
    	$("#new-educational-info").removeClass("hidden");
    	
    });
    
    
    // new leave request approval
    $(".new-row-approval").click(function(){
    	
    	$("#new-leave-approval-modal").removeClass("hidden");
    	
    });
    
   //close approval modal
    $(".close-approval-modal").click(function(){
    	
    	$("#new-leave-approval-modal").addClass("hidden");
  
    });
    
    

	//SALARY ADVANCE REQUEST
    $("#salaryAdvanceForm").submit(function(event){
    	event.preventDefault();
    	salaryRequest();
    });


    function salaryRequest(){
    	
    	var amount = $("#salary_adv_amount").val();
    	
    	var due_date = $("#sal-adv-due-date").val();
    	
    	var reason =  $("#sal_adv_due_date").val();
    	
    	var end_payment_date = $("#sal_adv_end_payment_date").val();
    	
    	var data = {amount:amount, due_date:due_date, reason:reason, end_payment_date:end_payment_date}
    	
    	console.log("amount", due_date);
    	
            $.ajax({
            	type: "POST",
                url: "http://localhost:8080/request-salary-advance", 
                data:data,
                success: function(result){
                    console.log(result);
                },
                error: function(){
                    console.log("Something is not going well!");	     
                }	    	
            });		
    };
	  
});

            $(".se-pre-con").fadeOut("slow");            
            $(".new-info-btn-experience").click(function(){
                    
                    $("#new-experience-info").removeClass("hidden");
                    
            });
            
            $(".new-info-btn-certification").click(function(){
                
                $("#new-certificate-info").removeClass("hidden");
                
            });
            
            $(".add-personal-info-btn").click(function(){
            	
          	  $("#new-personal-info-info").removeClass("hidden");
          	
            });
             
            $(".attach-avatar").click(function(){
            	
            	$("#upload_avatar").trigger("click");
            	
            });
            
//on change the avatar input file open the editing avatar model 
$("#upload_avatar").change(function(e){
    
    $("#new-avatar-editor").removeClass("hidden");
    
    addImage(e.target);
    
});

function addImage(data) {
    var file = data.files[0];
    if (file.type.indexOf('image') === -1) {
        alert('Sorry, the file you uploaded doesn\'t appear to be an image.');
        return false;
    }

    var reader = new FileReader();
    reader.onload = function(event) {
        var img = new Image();
        img.onload = function() {
            if (img.width < 200 || img.height < 200) {
                alert('Sorry, the image you uploaded doesn\'t appear to be large enough.');
                return false;
            }
            cropImage(img);
        }
        img.src = event.target.result;
    }
    reader.readAsDataURL(file);
}
function initializeDatepicker() {
    var fields = document.querySelectorAll('input[type="date"], input.date');
    Array.prototype.forEach.call(fields, (field) => {
        var dialog = new mdDateTimePicker.default({
            type: 'date',
            future: moment().add(21, 'years'),
            trigger: field
        });
        field.addEventListener('onOk', (e) => {
            field.value = dialog.time.format("YYYY-MM-DD");
        });
        field.addEventListener('click', function () {
            dialog.toggle();
        });
    });

   /*  var dialogH = new mdDateTimePicker.default({
        type: 'time'
    });

    var hour_to_go = $('#hourToGo');
    hour_to_go.click(function () {
        dialogH.toggle();
    }); */
}




