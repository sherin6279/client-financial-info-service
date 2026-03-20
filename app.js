let metawidgetInstance;
let formData = {};

window.onload = function () {

    formData = {
        clientName: "",
        annualIncome: 0,

        contactDetails: {
            email: "",
            phone: "",
            address: {
                unitNumber: "",
                street: "",
                city: "",
                state: "",
                country: "",
                postcode: ""
            }
        },

        investmentGoal: {
            goalName: "",
            targetAmount: 0,
            periodYears: 0,
            initialInvestmentAmount: 0
        },

        beneficiary: {
            name: "",
            relation: ""
        }
    };

    metawidgetInstance = new metawidget.Metawidget(document.getElementById('form'));
    metawidgetInstance.toInspect = formData;
    metawidgetInstance.buildWidgets();
};

function validate() {
    let errors = [];

    if (!formData.clientName || formData.clientName.trim() === "") {
        errors.push("Client name is required");
    }

    const email = formData.contactDetails.email || "";
    if (!email || !email.includes("@") || !email.includes(".")) {
        errors.push("Valid email is required");
    }

    if (!formData.annualIncome || formData.annualIncome <= 0) {
        errors.push("Annual income must be greater than 0");
    }

    if (!formData.investmentGoal.goalName) {
        errors.push("Investment goal is required");
    }

    if (formData.investmentGoal.targetAmount <= 0) {
        errors.push("Target amount must be greater than 0");
    }

    if (formData.investmentGoal.initialInvestmentAmount < 0) {
        errors.push("Initial investment cannot be negative");
    }

    return errors;
}

function showErrors(errors) {
    const errorDiv = document.getElementById("errors");

    if (errors.length === 0) {
        errorDiv.innerHTML = "";
        return;
    }

    let html = "<ul class='error'>";

    errors.forEach(e => {
        html += `<li>${e}</li>`;
    });
    html += "</ul>";

    errorDiv.innerHTML = html;
}

function saveData() {
    metawidgetInstance.save();

    const errors = validate();
    showErrors(errors);

    if (errors.length > 0) return;

    console.log("Form Data:", formData);
    // https://client-financial-info-service-production.up.railway.app
    // http://localhost:8080

    fetch("https://client-financial-info-service-production.up.railway.app/api/clients", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(res => res.json())
    .then(() => {
        alert("Information Saved successfully");
        resetForm();
    })
    .catch(() => alert("Backend not running, data logged in console"));
}

function resetForm() {
    formData.clientName = "";
    formData.annualIncome = 0;

    formData.contactDetails.email = "";
    formData.contactDetails.phone = "";

    formData.contactDetails.address.unitNumber = "";
    formData.contactDetails.address.street = "";
    formData.contactDetails.address.city = "";
    formData.contactDetails.address.state = "";
    formData.contactDetails.address.country = "";
    formData.contactDetails.address.postcode = "";

    formData.investmentGoal.goalName = "";
    formData.investmentGoal.targetAmount = 0;
    formData.investmentGoal.periodYears = 0;
    formData.investmentGoal.initialInvestmentAmount = 0;

    formData.beneficiary.name = "";
    formData.beneficiary.relation = "";

    document.getElementById("errors").innerHTML = "";

    metawidgetInstance.buildWidgets(); 
}