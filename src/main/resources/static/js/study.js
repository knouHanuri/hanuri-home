document.getElementById('studyForm').addEventListener('submit', function(event) {
    // 기본 제출 방지
    event.preventDefault();

    const inputs= [
        document.getElementById('title'),
        document.getElementById('status'),
        document.getElementById('schedule'),
        document.getElementById('startDate'),
        document.getElementById('endDate')
    ];

    let nullCnt = 0;
    for(let i = 0; i < inputs.length; i++){
        const input = inputs[i];
        if(!input.value.trim()){
            alert(document.querySelector(`label[for="${input.id}"]`).textContent + '은/는 필수 입력입니다.');
            input.focus();
            nullCnt++;
            return false;
        }
    }

    if(nullCnt === 0){
        if(confirm('스터디를 등록하시겠습니까?')){
            this.method = 'post';
            this.action = '/study/formSave';
            this.submit();
        }
    }
});
